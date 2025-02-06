package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class ArmSubsystem extends SubsystemBase {
  private final SparkMax m_arm = new SparkMax(10, MotorType.kBrushless);
  private RelativeEncoder encoder1;
  private RelativeEncoder encoder2;

  private final SparkMax m_grip = new SparkMax(17, MotorType.kBrushless);
  private RelativeEncoder grip_encoder;

  
  private final SparkMax m_wrist = new SparkMax(18, MotorType.kBrushless);
  private RelativeEncoder wrist_encoder1;
  private RelativeEncoder wrist_encoder2;
  private SparkMaxConfig wristConfig;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

  public ArmSubsystem() {
    encoder1 = m_arm.getEncoder();
    encoder2 = m_arm.getAlternateEncoder();
    
    grip_encoder = m_grip.getEncoder();

    wrist_encoder1 = m_wrist.getEncoder();
    wrist_encoder2 = m_wrist.getAlternateEncoder();
    wristConfig = new SparkMaxConfig();
    wristConfig.encoder.positionConversionFactor(1);
    wristConfig.encoder.velocityConversionFactor(1);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void armUp(double speed) {
    m_arm.setVoltage(speed);
  }
  
  public void armDown(double speed) {
    m_arm.setVoltage(-speed);
  }

  public double pos1(){
    return encoder1.getPosition();
  }

  public double pos2(){
    return encoder2.getPosition();
  }
  
  public double vel1(){
    return encoder1.getVelocity();
  }
  
  public double vel2(){
    return encoder2.getVelocity();
  }

  public double grip_vel(){
    return grip_encoder.getVelocity();
  }

  public void grip(double grip_speed) {
    m_grip.setVoltage(grip_speed);
  }
  
  public double get_wrist_pos1(){
    return wrist_encoder1.getPosition();
  }

  public double get_wrist_pos2(){
    return wrist_encoder2.getPosition();
  }

  public void turn_wrist(double wrist_speed) {
    m_wrist.setVoltage(wrist_speed);
  }

  public void turn_wrist_pos(double speed, double position) {
    m_wrist.setVoltage(speed);
  }
}
