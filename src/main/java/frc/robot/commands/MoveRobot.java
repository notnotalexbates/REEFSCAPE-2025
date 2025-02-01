// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;

public class MoveRobot extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  private final CommandXboxController controller;

  private double Y; // straight
  private double X; // strafe
  private double R; // turn

  public MoveRobot(DriveSubsystem subsystem, CommandXboxController driverController) {
    m_subsystem = subsystem;
    controller = driverController;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double threshold = 0.1;

    Y = controller.getLeftY() * OperatorConstants.straightmax;
    X = controller.getRightX() * OperatorConstants.strafemax;
    R = controller.getLeftX() * OperatorConstants.turnmax;

    if(Y < threshold && Y > -threshold){
      Y = 0;
    }
    if(X < threshold && X > -threshold){
      X = 0;
    }
    if(R < threshold && R > -threshold){
      R = 0;
    }

    m_subsystem.drive(-Y, X, R);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
