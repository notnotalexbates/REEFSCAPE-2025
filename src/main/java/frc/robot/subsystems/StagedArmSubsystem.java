package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class StagedArmSubsystem extends SubsystemBase {
    

    
    SparkMax stagmax = new SparkMax(16, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    RelativeEncoder StagEncoder1 = stagmax.getEncoder();
    RelativeEncoder StagEncoder2 = stagmax.getAlternateEncoder();

    public StagedArmSubsystem() {}

    public double pos1(){
        return StagEncoder1.getPosition();
    }

    public double pos2(){
        return StagEncoder2.getPosition();
    }

    public double vel1(){
        return StagEncoder1.getVelocity();
    }

    public double vel2(){
        return StagEncoder2.getVelocity();
    }
    
    public Command spin(double speed){
        return run(() -> stagmax.setVoltage(speed));
    }

    @Override
    public void periodic() {

    }
}


