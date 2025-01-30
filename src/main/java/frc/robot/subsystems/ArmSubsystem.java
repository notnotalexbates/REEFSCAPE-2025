// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ArmSubsystem extends SubsystemBase {
  
  src/main/java/frc/robot/commands/IntakeMotor.java
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

    SmartDashboard.putNumber("motor speed", get_speed());
    SmartDashboard.putNumber("motor position", get_Position());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }

  public void setMotorSpeed(double speed) {
    m_arm.set(speed); // speed is a value between -1 and 1
  }

  public double get_speed(){
    return encoder1.getVelocity();
  }

  public double get_Position(){
    return encoder2.getPosition();
  }

}
