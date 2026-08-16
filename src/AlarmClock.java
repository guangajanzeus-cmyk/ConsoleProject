import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable{

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.scanner = scanner;
        this.filePath = filePath;
    }

    @Override
    public void run(){

        while (LocalTime.now().isBefore(alarmTime)){

            try{

                Thread.sleep(1000);

                LocalTime now = LocalTime.now();

                int hours = now.getHour();
                int minutes = now.getMinute();
                int seconds = now.getSecond();

                System.out.printf("\r%02d:%02d:%02d", hours,minutes,seconds);

            }
            catch (InterruptedException e ){
                System.out.println("Thread was Interrupted");
            }
        }

        playSound(filePath);


    }

    public void playSound(String filePath){

        File audioFile = new File(filePath);

        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("\npress *ENTER* to stop the alarm: ");
            scanner.nextLine();

            clip.stop();

            System.out.println("**You Stop the Alarm**");

            scanner.close();
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("The file is unsupported");
        }
        catch (LineUnavailableException e) {
            System.out.println("Audio format is not available");
        }
        catch (IOException e){
            System.out.println("Error reading audio file");
        }


    }

}
