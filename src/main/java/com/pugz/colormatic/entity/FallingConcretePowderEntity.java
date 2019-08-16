package com.pugz.colormatic.entity;

import com.pugz.colormatic.block.BetterConcretePowderBlock;
import com.pugz.colormatic.registry.ColormaticEntities;
import net.minecraft.block.*;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.*;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

public class FallingConcretePowderEntity extends Entity {

    private BlockState fallTile = Blocks.SAND.getDefaultState();
    public int fallTime;
    public boolean shouldDropItem = true;
    private int layers;
    protected static final DataParameter<BlockPos> ORIGIN = EntityDataManager.createKey(FallingConcretePowderEntity.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Integer> LAYERS = EntityDataManager.createKey(FallingConcretePowderEntity.class, DataSerializers.VARINT);

    public FallingConcretePowderEntity(EntityType<? extends FallingConcretePowderEntity> entityType, World world) {
        super(entityType, world);
        layers = 1;
    }

    public FallingConcretePowderEntity(World worldIn, double x, double y, double z, BlockState fallingBlockState, int layersIn) {
        this(ColormaticEntities.FALLING_CONCRETE_POWDER, worldIn);
        fallTile = fallingBlockState;
        preventEntitySpawning = true;
        setPosition(x, y + (double)((1.0F - getHeight()) / 2.0F), z);
        setMotion(Vec3d.ZERO);
        prevPosX = x;
        prevPosY = y;
        prevPosZ = z;
        layers = layersIn;
        setData(new BlockPos(this), layersIn);
    }

    public boolean canBeAttackedWithItem() {
        return false;
    }

    public void setData(BlockPos pos, int layers) {
        dataManager.set(ORIGIN, pos);
        dataManager.set(LAYERS, layers);
    }

    @OnlyIn(Dist.CLIENT)
    public BlockPos getOrigin() {
        return dataManager.get(ORIGIN);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void registerData() {
        dataManager.register(ORIGIN, BlockPos.ZERO);
        dataManager.register(LAYERS, layers);
    }

    @OnlyIn(Dist.CLIENT)
    public int getLayers()
    {
        return dataManager.get(LAYERS);
    }

    public boolean canBeCollidedWith() {
        return !removed;
    }

    public void tick() {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        Block block = fallTile.getBlock();
        if (fallTime++ == 0) {
            BlockPos blockpos = new BlockPos(this);
            if (world.getBlockState(blockpos).getBlock() == block) {
                world.removeBlock(blockpos, false);
            } else if (!world.isRemote) {
                remove();
                return;
            }
        }
        if (!hasNoGravity()) {
            setMotion(getMotion().add(0.0D, -0.04D, 0.0D));
        }
        move(MoverType.SELF, getMotion());
        if (!world.isRemote) {
            BlockPos blockpos1 = new BlockPos(this);
            boolean flag = fallTile.getBlock() instanceof ConcretePowderBlock;
            boolean flag1 = flag && world.getFluidState(blockpos1).isTagged(FluidTags.WATER);
            double d0 = getMotion().lengthSquared();
            if (flag && d0 > 1.0D) {
                BlockRayTraceResult blockraytraceresult = world.rayTraceBlocks(new RayTraceContext(new Vec3d(prevPosX, prevPosY, prevPosZ), new Vec3d(posX, posY, posZ), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.SOURCE_ONLY, this));
                if (blockraytraceresult.getType() != RayTraceResult.Type.MISS && world.getFluidState(blockraytraceresult.getPos()).isTagged(FluidTags.WATER)) {
                    blockpos1 = blockraytraceresult.getPos();
                    flag1 = true;
                }
            }
            if (!onGround && !flag1) {
                if (!world.isRemote && (fallTime > 100 && (blockpos1.getY() < 1 || blockpos1.getY() > 256) || fallTime > 600)) {
                    if (shouldDropItem && world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            entityDropItem(block);
                        }
                        remove();
                    }
            } else {
                BlockState blockstate = world.getBlockState(blockpos1);
                setMotion(getMotion().mul(0.7D, -0.5D, 0.7D));
                if (blockstate.getBlock() != Blocks.MOVING_PISTON) {
                    //((BetterConcretePowderBlock)block).addLayers(world, new BlockPos(posX, posY, posZ), layers);
                    remove();
                }
            }
        }
        setMotion(getMotion().scale(0.98D));
    }

    protected void writeAdditional(CompoundNBT compound) {
        compound.put("BlockState", NBTUtil.writeBlockState(fallTile));
        compound.putInt("Time", fallTime);
        compound.putInt("Layers", layers);
        compound.putBoolean("DropItem", shouldDropItem);
    }

    protected void readAdditional(CompoundNBT compound) {
        fallTile = NBTUtil.readBlockState(compound.getCompound("BlockState"));
        fallTime = compound.getInt("Time");
        if (compound.contains("DropItem", 99)) {
            shouldDropItem = compound.getBoolean("DropItem");
        }

        if (compound.contains("Layers", Constants.NBT.TAG_INT))
        {
            layers = compound.getInt("Layers");
        }

        if (fallTile.isAir()) {
            fallTile = Blocks.SAND.getDefaultState();
        }

    }

    @OnlyIn(Dist.CLIENT)
    public World getWorldObj() {
        return world;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    public void fillCrashReport(CrashReportCategory category) {
        super.fillCrashReport(category);
        category.addDetail("Immitating BlockState", fallTile.toString());
    }

    public BlockState getBlockState() {
        return fallTile;
    }

    public boolean ignoreItemEntityData() {
        return true;
    }

    public IPacket<?> createSpawnPacket() {
        return new SSpawnObjectPacket(this, Block.getStateId(getBlockState()));
    }
}