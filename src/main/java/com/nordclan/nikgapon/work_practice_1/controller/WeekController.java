package com.nordclan.nikgapon.work_practice_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

@Controller
@RequestMapping("/week")
public class WeekController {
    @GetMapping(value = {"/", "", "/{weeknumber}"})
    public String week(@PathVariable(required = false) Long weeknumber, Model model){
        Calendar calendar = new GregorianCalendar();
        Locale locale = Locale.UK;
        if (weeknumber == null || weeknumber == 0) {
            calendar.setTime(new Date());
        }
        else {
            calendar.setTime(java.sql.Date.valueOf(LocalDate.now().plusDays(7 * weeknumber)));
        }
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        for (int i = 0; i < 7; i++) {
            String nameOfMonth = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
            String nameOfDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            System.out.println(dayOfMonth + ": " + calendar.getTime());
            //23: Mon Sep 23 14:25:50 GMT+04:00 2024
            //24: Tue Sep 24 14:25:50 GMT+04:00 2024
            // 5. increase day field; add() will adjust the month if neccessary
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }


        //model.addAttribute("curentweek");
        return "week";
    }
}
