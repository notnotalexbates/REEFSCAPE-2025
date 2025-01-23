// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.StagedArmSubsystem;

public class RobotContainer {

  private final ArmSubsystem m_armsubsystem = new ArmSubsystem();
  private final StagedArmSubsystem m_stagedarm = new StagedArmSubsystem();

  private final CommandXboxController m_driverController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  public void updateEncoderValues() {
    SmartDashboard.putNumber("endcoder1", m_armsubsystem.pos1());
    SmartDashboard.putNumber("endcoder2", m_armsubsystem.pos2());
    SmartDashboard.putNumber("velocity1", m_armsubsystem.vel1());
    SmartDashboard.putNumber("velocity2", m_armsubsystem.vel2());

    SmartDashboard.putNumber("stag encoder1", m_stagedarm.pos1());
    SmartDashboard.putNumber("stag endcoder2", m_stagedarm.pos2());
    SmartDashboard.putNumber("stag vel1", m_stagedarm.vel1());
    SmartDashboard.putNumber("stag vel2", m_stagedarm.vel2());
  }

  private void configureBindings() {
    m_driverController.a().toggleOnTrue(m_armsubsystem.spin(3));
    m_driverController.b().toggleOnTrue(m_armsubsystem.spin(-3));
    m_driverController.a().toggleOnFalse(m_armsubsystem.spin(0));
    m_driverController.b().toggleOnFalse(m_armsubsystem.spin(0));

    m_driverController.x().toggleOnTrue(m_stagedarm.spin(1));
    m_driverController.y().toggleOnTrue(m_stagedarm.spin(-1));
    m_driverController.x().toggleOnFalse(m_stagedarm.spin(0));
    m_driverController.y().toggleOnFalse(m_stagedarm.spin(0));

  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
