package com.pugz.colormatic.entity;

import com.google.common.collect.Lists;
import com.pugz.colormatic.block.BetterConcretePowderBlock2;
import com.pugz.colormatic.registry.ColormaticEntities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;
import java.util.Random;

public class FallingConcretePowderEntity2 extends Entity {
    public int fallTime;
    private BlockPos prevPos;
    private int layers;
    private BlockState fallingState;
    protected static final DataParameter<BlockPos> ORIGIN = EntityDataManager.createKey(FallingConcretePowderEntity2.class, DataSerializers.BLOCK_POS);
    private static final DataParameter<Integer> LAYERS = EntityDataManager.createKey(FallingConcretePowderEntity2.class, DataSerializers.VARINT);
    private EntitySize size;

    public FallingConcretePowderEntity2(EntityType<? extends FallingConcretePowderEntity2> entityType, World worldIn) {
        super(entityType, worldIn);
        prevPos = BlockPos.ZERO;
        layers = 1;
        size = new EntitySize(0.98f, 0.1225f * layers, true);
    }

    public FallingConcretePowderEntity2(World worldIn, double x, double y, double z, BlockState fallingStateIn, int layersIn) {
        this(ColormaticEntities.FALLING_CONCRETE_POWDER_2, worldIn);
        preventEntitySpawning = true;
        setPosition(x, y + (1.0F - getHeight()) / 2.0F, z);
        setMotion(Vec3d.ZERO);
        prevPosX = x;
        prevPosY = y;
        prevPosZ = z;
        layers = layersIn;
        fallingState = fallingStateIn;
        setData(new BlockPos(this), layers);
        prevPos = new BlockPos(this);
        size = new EntitySize(0.98f, 0.1225f * layers, true);
    }

    @Override
    public EntitySize getSize(Pose poseIn) {
        return size;
    }

    /*
    @Override
    public void tick() {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        ++fallTime;
        if (!hasNoGravity()) {
            setMotion(getMotion().add(0.0D, -0.04D, 0.0D));
        }
        move(MoverType.SELF, getMotion());
        BlockPos pos = new BlockPos(this);
        if (!world.isRemote) {
            if (!onGround) {
                if (fallTime > 100 && !world.isRemote && (pos.getY() < 1 || pos.getY() > 256) || fallTime > 600) {
                    remove();
                } else if (!pos.equals(prevPos)) {
                    prevPos = pos;
                    BlockState state = world.getBlockState(pos);
                    if (state.getMaterial() == Material.LAVA) {
                        if (world.isRemote) {
                            Random random = world.rand;
                            for (int i = 0; i < 10; ++i) {
                                double d0 = random.nextGaussian() * 0.02D;
                                double d1 = random.nextGaussian() * 0.02D;
                                double d2 = random.nextGaussian() * 0.02D;
                                world.addParticle(ParticleTypes.SMOKE, pos.getX() + random.nextFloat(), pos.getY() + 1, pos.getZ() + random.nextFloat(), d0, d1, d2);
                            }
                        }
                        world.playSound(null, pos.up(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.AMBIENT, 0.8F, 0.8F);
                        remove();
                        return;
                    }
                    if (state.getMaterial().isLiquid()) {
                        remove();
                        return;
                    }
                }
            } else {
                BlockState state = world.getBlockState(pos);
                setMotion(getMotion().mul(0.7D, -0.5D, 0.7D));
                if (state.getBlock() != Blocks.MOVING_PISTON) {
                    if (state.getCollisionShape(world, pos, ISelectionContext.forEntity(this)).isEmpty()) {
                        BlockPos posDown = pos.down();
                        BlockState stateDown = world.getBlockState(posDown);
                        Block block = stateDown.getBlock();
                        if (block instanceof FenceBlock || block instanceof FenceGateBlock || block instanceof WallBlock || block instanceof StairsBlock && stateDown.get(StairsBlock.HALF) == Half.BOTTOM) {
                            pos = posDown;
                        }
                        if (block instanceof BetterConcretePowderBlock2 && block == fallingState.getBlock()) {
                            BetterConcretePowderBlock2.addLayers(world, pos, fallingState.getBlock(), layers, true, new DirectionalPlaceContext(world, pos, Direction.DOWN, ItemStack.EMPTY, Direction.UP), true);
                        }
                    }
                    remove();
                    return;
                }
            }
        }
        setMotion(getMotion().scale(0.98D));
    }
    */

    public void tick() {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        Block block = fallingState.getBlock();
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
            boolean flag1 = world.getFluidState(blockpos1).isTagged(FluidTags.WATER);
            double d0 = getMotion().lengthSquared();
            if (d0 > 1.0D) {
                BlockRayTraceResult blockraytraceresult = world.rayTraceBlocks(new RayTraceContext(new Vec3d(prevPosX, prevPosY, prevPosZ), new Vec3d(posX, posY, posZ), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.SOURCE_ONLY, this));
                if (blockraytraceresult.getType() != RayTraceResult.Type.MISS && world.getFluidState(blockraytraceresult.getPos()).isTagged(FluidTags.WATER)) {
                    blockpos1 = blockraytraceresult.getPos();
                    flag1 = true;
                }
            }
            if (!onGround && !flag1) {
                if (!world.isRemote && (fallTime > 100 && (blockpos1.getY() < 1 || blockpos1.getY() > 256) || fallTime > 600)) {
                    if (world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                        entityDropItem(block);
                    }
                    remove();
                }
            }
            else {
                BlockState blockstate = world.getBlockState(blockpos1);
                setMotion(getMotion().mul(0.7D, -0.5D, 0.7D));
                if (blockstate.getBlock() != Blocks.MOVING_PISTON) {
                    remove();
                    boolean flag2 = blockstate.isReplaceable(new DirectionalPlaceContext(world, blockpos1, Direction.DOWN, ItemStack.EMPTY, Direction.UP));
                    boolean flag3 = fallingState.isValidPosition(world, blockpos1);
                    if (flag2 && flag3) {
                        if (fallingState.has(BlockStateProperties.WATERLOGGED) && world.getFluidState(blockpos1).getFluid() == Fluids.WATER) {
                            fallingState = fallingState.with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true));
                        }
                        if (world.setBlockState(blockpos1, fallingState, 3)) {
                            if (block instanceof BetterConcretePowderBlock2) {
                                //((BetterConcretePowderBlock2)block).addLayers(world, blockpos1, block, layers, true, getWorldObj(), true);
                            }
                        } else if (world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            entityDropItem(block);
                        }
                    } else if (world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                        entityDropItem(block);
                    }
                }
            }
        }
        setMotion(this.getMotion().scale(0.98D));
    }

    public void setData(BlockPos pos, int layers) {
        dataManager.set(ORIGIN, pos);
        dataManager.set(LAYERS, layers);
    }

    @OnlyIn(Dist.CLIENT)
    public BlockPos getOrigin() {
        return dataManager.get(ORIGIN);
    }

    @OnlyIn(Dist.CLIENT)
    public int getLayers() {
        return dataManager.get(LAYERS);
    }

    @OnlyIn(Dist.CLIENT)
    public World getWorldObj() {
        return world;
    }

    @Override
    public boolean canBeCollidedWith() {
        return isAlive();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }

    @Override
    protected void registerData() {
        dataManager.register(ORIGIN, BlockPos.ZERO);
        dataManager.register(LAYERS, 1);
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        fallTime = compound.getInt("Time");
        if (compound.contains("Layers", Constants.NBT.TAG_INT)) {
            layers = compound.getInt("Layers");
            size = new EntitySize(0.98f, 0.1225f * layers, true);
        }
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("Time", fallTime);
        compound.putInt("Layers", layers);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}