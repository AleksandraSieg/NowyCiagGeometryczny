package pl.madison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Liczba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    List<Integer> liczbyDoSprawdzenia = new ArrayList<Integer>();
    Integer[] nowyCiag = new Integer[liczbyDoSprawdzenia.size()];

    @RequestMapping(value = "/wstawLiczby")
    public String wstawLiczby(Map<String, Object> model){
        model.put("wpisz", new Liczba());
        return "wpisz";
    }

    @RequestMapping(value = "/wyswietl", method = RequestMethod.POST)
    public String wyswietl(Liczba liczba, Map<String, Object> model){

        liczbyDoSprawdzenia.add(liczba.getLiczba1());
        liczbyDoSprawdzenia.add(liczba.getLiczba2());
        liczbyDoSprawdzenia.add(liczba.getLiczba3());
        liczbyDoSprawdzenia.add(liczba.getLiczba4());

        boolean czyTakiSam = true;

        int q = liczba.getLiczba2()/liczba.getLiczba1();

        for (int i = 0; i < nowyCiag.length; i++) {
            nowyCiag[0] = liczba.getLiczba1();
            nowyCiag[i+1] = nowyCiag[i]*q;
        }


        for(int i = 0; i<nowyCiag.length; i++){
            if(!nowyCiag[i].equals(liczbyDoSprawdzenia.get(i))){
                czyTakiSam = false;
            }
        }


        model.put("bcd", czyTakiSam);
        return "wynikSprawdzenia";
    }
}
