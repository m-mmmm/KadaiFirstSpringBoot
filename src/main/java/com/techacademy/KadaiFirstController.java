package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // 追加
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        //日付のフォーマットをyyymmddに設定
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        //valのフォーマットを変換
        LocalDate ld = LocalDate.parse(date, format);
        //曜日を取得
        DayOfWeek dayofweek = ld.getDayOfWeek();
        return "実行結果：" + dayofweek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }


    // ----- 追加:ここから -----
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }
    // ----- 追加:ここから -----
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

 // ----- 追加:ここから -----
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }
 // ----- 追加:ここから -----
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }

}
