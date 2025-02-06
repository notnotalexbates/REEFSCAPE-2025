package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class DriveSubsystem extends SubsystemBase {
  private final SparkMax m_frontLeft = new SparkMax(11, MotorType.kBrushless);
  private final SparkMax m_rearLeft = new SparkMax(12, MotorType.kBrushless);
  private final SparkMax m_frontRight = new SparkMax(13, MotorType.kBrushless);
  private final SparkMax m_rearRight = new SparkMax(14, MotorType.kBrushless);

  private final SparkMaxConfig configFR = new SparkMaxConfig();
  private final SparkMaxConfig configRR = new SparkMaxConfig();
  MecanumDrive m_drive;
 
  public DriveSubsystem() {
    configFR.inverted(true);
    configRR.inverted(true);

    m_frontRight.configure(configFR, null, null);
    m_rearRight.configure(configRR, null, null);

    m_drive = new MecanumDrive(m_frontLeft::set, m_rearLeft::set, m_frontRight::set, m_rearRight::set);

    SendableRegistry.addChild(m_drive, m_frontLeft);
    SendableRegistry.addChild(m_drive, m_rearLeft);
    SendableRegistry.addChild(m_drive, m_frontRight);
    SendableRegistry.addChild(m_drive, m_rearRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void drive(double xSpeed, double ySpeed, double rot) {
    m_drive.driveCartesian(xSpeed, ySpeed, rot);
  }

}
