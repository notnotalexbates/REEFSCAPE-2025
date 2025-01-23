// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ArmSubsystem extends SubsystemBase {
  private final SparkMax m_arm = new SparkMax(10, MotorType.kBrushless);
  private RelativeEncoder encoder1;
  private RelativeEncoder encoder2; 

  private final SparkMaxConfig configarm = new SparkMaxConfig();

  public ArmSubsystem() {
    encoder1 = m_arm.getEncoder();
    encoder2 = m_arm.getAlternateEncoder(); 
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  double motorspeed = 0.0;

  }

 // double motor_angle = 

}
