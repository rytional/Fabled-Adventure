package net.rytional.fabledadventure.entity.ai.goal;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.rytional.fabledadventure.entity.custom.OrcEntity;

public class OrcAttackGoal
        extends MeleeAttackGoal {
    private final OrcEntity orc;
    private int ticks;

    public OrcAttackGoal(OrcEntity orc, double speed, boolean pauseWhenMobIdle) {
        super(orc, speed, pauseWhenMobIdle);
        this.orc = orc;
    }

    @Override
    public void start() {
        super.start();
        this.ticks = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.orc.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.orc.setAttacking(true);
        } else {
            this.orc.setAttacking(false);
        }
    }
}
