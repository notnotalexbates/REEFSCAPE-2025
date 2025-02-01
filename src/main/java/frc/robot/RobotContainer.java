// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.GripperIntake;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

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

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger00 bindings
    configureBindings();
    System.out.print("something");
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_driverController.a().whileTrue(new GripperIntake(m_robotArm,7));
    m_driverController.b().whileTrue(new GripperIntake(m_robotArm,-4));
    m_driverController.x().whileTrue(new GripperIntake(m_robotArm,9));
    m_driverController.y().whileTrue(new GripperIntake(m_robotArm,-4));

    double controllerThreshold = 0.1;
    DoubleSupplier leftY = () -> -applyDeadband(m_driverController.getLeftY() * OperatorConstants.straightmax, controllerThreshold);
    DoubleSupplier rightX = () -> applyDeadband(m_driverController.getRightX() * OperatorConstants.strafemax, controllerThreshold);
    DoubleSupplier leftX = () -> applyDeadband(m_driverController.getLeftX() * OperatorConstants.turnmax, controllerThreshold);

    m_robotDrive.setDefaultCommand(new DriveCommand(m_robotDrive, leftY, rightX, leftX));
  }

  private static double applyDeadband(double input, double threshold) {
    return Math.abs(input) < threshold ? 0 : input;
  }
}
