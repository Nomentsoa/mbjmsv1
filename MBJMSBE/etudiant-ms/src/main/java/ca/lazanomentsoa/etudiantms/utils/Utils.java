package ca.lazanomentsoa.etudiantms.utils;

import ca.lazanomentsoa.etudiantms.dto.ecolage.EcolagePayDateAndEtatDTO;
import ca.lazanomentsoa.etudiantms.entity.ecologe.Ecolage;
import ca.lazanomentsoa.etudiantms.entity.ecologe.EtatEcolage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

public  class Utils {

    public static Ecolage setPaydDate(Ecolage ecolage, List<Integer> mois){
        LocalDate nowDate = LocalDate.now();
        for (Integer moisId : mois) {
            switch (moisId) {
                case 9:
                    ecolage.setSeptembre(nowDate);
                    ecolage.setPaydSeptembre(true);
                    break;
                case 10:
                    ecolage.setOctobre(nowDate);
                    ecolage.setPaydOctobre(true);
                    break;
                case 11:
                    ecolage.setNovembre(nowDate);
                    ecolage.setPaydNovembre(true);
                    break;
                case 12:
                    ecolage.setDecembre(nowDate);
                    ecolage.setPaydDecembre(true);
                    break;
                case 1:
                    ecolage.setJanvier(nowDate);
                    ecolage.setPaydJanvier(true);
                    break;
                case 2:
                    ecolage.setFevrier(nowDate);
                    ecolage.setPaydFevrier(true);
                    break;
                case 3:
                    ecolage.setMars(nowDate);
                    ecolage.setPaydMars(true);
                    break;
                case 4:
                    ecolage.setMai(nowDate);
                    ecolage.setPaydMai(true);
                    break;
                case 5:
                    ecolage.setJuin(nowDate);
                    ecolage.setPaydJuin(true);
                    break;
                case 6:
                    ecolage.setJuillet(nowDate);
                    ecolage.setPaydJuillet(true);
                    break;
                default:
                    break;
            }
        }
        return ecolage;
    }

    public static EtatEcolage getEtatEcolageDuMois(Ecolage ecolage, int mois){
        LocalDate nowDate = LocalDate.now();


        int annee = switch ((Integer) mois){
            case Integer annneeDumoi when annneeDumoi >=1  && annneeDumoi <= 6 -> Integer.parseInt(ecolage.getAnneeScolaire().split("-")[1]);
            default -> Integer.parseInt(ecolage.getAnneeScolaire().split("-")[0]);
        };

        EcolagePayDateAndEtatDTO datePayementEcolage = switch (mois){
            case 9 -> new EcolagePayDateAndEtatDTO(ecolage.getSeptembre(), ecolage.isPaydSeptembre());
            case 10-> new EcolagePayDateAndEtatDTO(ecolage.getOctobre(), ecolage.isPaydOctobre());
            case 11-> new EcolagePayDateAndEtatDTO(ecolage.getNovembre(), ecolage.isPaydNovembre());
            case 12-> new EcolagePayDateAndEtatDTO(ecolage.getDecembre(), ecolage.isPaydDecembre());
            case 1-> new EcolagePayDateAndEtatDTO(ecolage.getJanvier(), ecolage.isPaydJanvier());
            case 2-> new EcolagePayDateAndEtatDTO(ecolage.getFevrier(), ecolage.isPaydFevrier());
            case 3-> new EcolagePayDateAndEtatDTO(ecolage.getMars(), ecolage.isPaydMars());
            case 4-> new EcolagePayDateAndEtatDTO(ecolage.getMai(), ecolage.isPaydMai());
            case 5-> new EcolagePayDateAndEtatDTO(ecolage.getJuin(), ecolage.isPaydJuin());
            case 6-> new EcolagePayDateAndEtatDTO(ecolage.getJuillet(), ecolage.isPaydJuillet());
            default -> throw new IllegalStateException("Unexpected value: " + mois);
        };

        if(datePayementEcolage.etat()){
            return EtatEcolage.PAYE;
        }else {
            if(datePayementEcolage.payDate()  == null){
                long differenceDateToDayAndLimit = ChronoUnit.DAYS.between(nowDate, LocalDate.of(annee, mois, 10));
                if(differenceDateToDayAndLimit >=3)
                    return EtatEcolage.ENATTENTE;
                else if(differenceDateToDayAndLimit <= 0){
                    return EtatEcolage.ENRETARD;
                }else  {
                    return EtatEcolage.AVERTISSEMENT;
                }
            }else {
                long differenceDateToDayAndLimit = ChronoUnit.DAYS.between(nowDate, datePayementEcolage.payDate());
                if(differenceDateToDayAndLimit >=3)
                    return EtatEcolage.ENATTENTE;
                else if(differenceDateToDayAndLimit <= 0){
                    return EtatEcolage.ENRETARD;
                }else  {
                    return EtatEcolage.AVERTISSEMENT;
                }
            }
        }

    }
}
