// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.ArmSubsystem;
// import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj2.command.Command;

// /** An example command that uses an example subsystem. */
// public class TrapSpeed extends Command {
//   @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//   private final ArmSubsystem m_subsystem;
//   private double curr_pos;
//   private double buffer;
//   private double x0;
//   private double x_final;
//   private double Velocitymax;
//   private double Accelmax;


//   /**
//    * Creates a new ExampleCommand.
//    *
//    * @param subsystem The subsystem used by this command.
//    */
//   public TrapSpeed(ArmSubsystem subsystem, double xf, double Vmax, double Amax) {
//     m_subsystem = subsystem;
//     x_final = xf;
//     Velocitymax = Vmax;
//     Accelmax = Amax;
//     // Use addRequirements() here to declare subsystem dependencies.
//     addRequirements(subsystem);
    
    
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {}

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
    
//     x0 = m_subsystem.get_pitch_encoder2();
//     while (x0 - buffer <= m_subsystem.get_pitch_encoder2() & m_subsystem.get_pitch_encoder2() <= x_final);
//     curr_pos = m_subsystem.get_pitch_encoder2();
//     if (curr_pos < (Velocitymax/ 40 * Accelmax))
//     {m_subsystem.staged_pitch(Velocitymax/40);}
//     else if (curr_pos >= Velocitymax / 40 * Accelmax);
//     {m_subsystem.staged_pitch(Accelmax * curr_pos);}
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
