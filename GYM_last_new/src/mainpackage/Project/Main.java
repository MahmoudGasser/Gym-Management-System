package mainpackage.Project;
import mainpackage.*;

import java.io.IOException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{


    public static void main(String[] args) throws IOException
    {



        Scanner scanner=new Scanner(System.in);

        main_project mainProject= new main_project();
      mainProject.Loading();
       mainProject.main_menu();


    }
}


