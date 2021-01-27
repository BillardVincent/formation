package fr.dawan.java_interm.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeTest {

	public static void main(String[] args) {
		//Avant Java 1.8
        Date d1 = new Date();//englobe la date et l'heure
        System.out.println(d1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        System.out.println(sdf.format(d1));
        
        //Par défaut Calendar.getInstanc récupère un GregorianCalendar
        Calendar myCal = GregorianCalendar.getInstance();
        myCal.set(2021, 0, 23); // 23/01/2021 - Attention : ici month commence à 0 (Janvier) => Dec : 11
        Date d2 = myCal.getTime();
        System.out.println(d2);
        
        //il existe d'autres Calendar : 
        //BuddhistCalendar
        //JapaneseImperialCalendar
        
        try {
                Date d3 = sdf.parse("12/03/2020");
                System.out.println(d3);
                
                long nbMsFromEpoch = d3.getTime(); //nombre de ms depuis 01/01/1970
                System.out.println(nbMsFromEpoch);
                
                System.out.println("comparaison d3 avec d2 : " + d3.compareTo(d2));
        } catch (ParseException e) {
                e.printStackTrace();
        }
        
        
        // ----------Apres java 1.8 ---------------
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2020,1,25)); // format par défaut : yyyy-MM-dd
        System.out.println(LocalTime.of(16, 46));
        System.out.println(LocalDateTime.now(ZoneId.of("GMT+1")));
        System.out.println(LocalDateTime.now(ZoneId.of("Europe/Paris")));
        
        Duration duration1 = Duration.of(24, ChronoUnit.HOURS);
        Duration.ofDays(1);
        
        // comparaison de 2 instants:
        //Duration.between(null, null);
        
        //comparason de 2 dates:
        Period p = Period.between(LocalDate.now(), LocalDate.of(2020,2,14));
        System.out.println(p);
        System.out.println(p.getYears() + "years " + p.getDays() + "days");
        System.out.println(p.get(ChronoUnit.DAYS)+ "days");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDateTime.now().format(dtf));
        System.out.println(dtf.format(LocalDateTime.now()));
        
        
        // passage de l'un à l'autre :
        Date utilDate1 = new Date();
        Instant inst1 = utilDate1.toInstant();
        
        // LocalDateTime ldt = LocalDateTime.from(inst1);



	}

}
