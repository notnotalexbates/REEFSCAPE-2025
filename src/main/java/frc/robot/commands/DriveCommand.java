package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem m_driveSubsystem;
    private final DoubleSupplier forward;
    private final DoubleSupplier strafe;
    private final DoubleSupplier rotation;

    public DriveCommand(DriveSubsystem drive, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier rotation) {
        this.m_driveSubsystem = drive;
        this.forward = forward;
        this.strafe = strafe;
        this.rotation = rotation;
        addRequirements(drive);
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveSubsystem.drive(forward.getAsDouble(), strafe.getAsDouble(), rotation.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_driveSubsystem.drive(0, 0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
