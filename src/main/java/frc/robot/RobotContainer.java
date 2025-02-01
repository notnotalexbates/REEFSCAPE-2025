// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeMotor;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.commands.GripperIntake;
import frc.robot.commands.MoveRobot;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ArmSubsystem m_robotArm = new ArmSubsystem();
  private double Y;
  private double X;
  private double R;

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
    m_robotDrive.setDefaultCommand(new MoveRobot(m_robotDrive, m_driverController));
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(new IntakeMotor(m_robotArm,0.1));
    m_driverController.b().whileTrue(new IntakeMotor(m_robotArm,-0.1));    m_driverController.a().whileTrue(new GripperIntake(m_robotArm,7));
    m_driverController.b().whileTrue(new GripperIntake(m_robotArm,-4));
    m_driverController.x().whileTrue(new GripperIntake(m_robotArm,9));
    m_driverController.y().whileTrue(new GripperIntake(m_robotArm,-4));

    Y = m_driverController.getLeftY();
    X = m_driverController.getRightX();
    R = m_driverController.getLeftX();
  }
}
