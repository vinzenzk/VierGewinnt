package gymhum.de;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gymhum.de.model.Feld;
import gymhum.de.model.Gewonnen;
import gymhum.de.model.Spieler;



@Controller
public class SpielController {
    
    Feld[][] felder;
    Spieler s1;
    Gewonnen g1;
    public SpielController() {
        setFelder(new Feld[6][7]);
        setS1(new Spieler(true));
        setG1(new Gewonnen(false));
        initFeld();
        testLauf();
        showTestFeld();

    }


    @GetMapping("/Spiel")
    public String showSpiele(@RequestParam(name="activePage", required = false, defaultValue = "Spiele") String activePage, Model model)
    {
        model.addAttribute("activePage", "Spiel");
        model.addAttribute("felder", getFelder());   
        model.addAttribute("gewonnen",  getG1());
        return "index.html";
    }

    @GetMapping("/playerInt")
    public String showSpielX(@RequestParam(name="activePage", required = true, defaultValue = "Spiel") String activePage, @RequestParam(name="id", required = true) int id, Model model) {
        //model.addAttribute("gewonnen",  getG1());
        for(int i = 5; i >= 0; i--) {
            if(getFelder()[i][id].getFrei()) {
                if(s1.getSpieler() == true) {
                    getFelder()[i][id].setFrei(false);
                    getFelder()[i][id].setXo(false);
                    s1.setSpieler(false);
                    System.out.println("Feld 77 wurde geändert");  
                    break;    
                } 
                else if(s1.getSpieler()== false) {
                    getFelder()[i][id].setFrei(false);
                    getFelder()[i][id].setXo(true);
                    s1.setSpieler(true);   
                    System.out.println("Feld wurde geändert");  
                    break;              
                }             
            } 
        }
        testLauf();
        System.out.println("HalloWler");
        return "redirect:/Spiel";
        
    }

    private void initFeld() {
        for(int i = 0; i <6; i++) {
            for(int k = 0; k <7; k++){
                getFelder()[i][k] = new Feld();
            }
        }
    }

    private void showTestFeld() {
        for(int i = 0; i <6; i++) {
            System.out.println(" ");
            for(int k = 0; k <7; k++){
                System.out.print(getFelder()[i][k].getFrei() + " ");
                

            }
        }      
    }

    private void testLauf(){
        
        for(int i= 0; i<6; i++) {
            for(int k = 0; k <=3; k++) {
                if(getFelder()[i][k].getFrei()==false && getFelder()[i][k+1].getFrei()==false && getFelder()[i][k+2].getFrei()==false && getFelder()[i][k+3].getFrei()==false) {
                    if(getFelder()[i][k].getXo()==false && getFelder()[i][k+1].getXo()==false && getFelder()[i][k+2].getXo()==false && getFelder()[i][k+3].getXo()==false){
                        System.out.println("2Spieler X hat gewonnen");
                        g1.setGewonnen(true);
                        
                    } else if(getFelder()[i][k].getXo() && getFelder()[i][k+1].getXo() && getFelder()[i][k+2].getXo() && getFelder()[i][k+3].getXo()) {
                    System.out.println("2Spieler O hat gewonnen");
                    g1.setGewonnen(true);
                    }
                }
            }
        }

        for(int i= 0; i<=2; i++) {
            for(int k = 0; k <7; k++) {
                if(getFelder()[i][k].getFrei()==false && getFelder()[i+1][k].getFrei()==false && getFelder()[i+2][k].getFrei()==false && getFelder()[i+3][k].getFrei()==false) {
                    if(getFelder()[i][k].getXo()==false && getFelder()[i+1][k].getXo()==false && getFelder()[i+2][k].getXo()==false && getFelder()[i+3][k].getXo()==false){
                        System.out.println("3Spieler X hat gewonnen");
                        g1.setGewonnen(true);
                    } else if(getFelder()[i][k].getXo() && getFelder()[i+1][k].getXo() && getFelder()[i+2][k].getXo() && getFelder()[i+3][k].getXo()) {
                    System.out.println("3Spieler O hat gewonnen");
                    g1.setGewonnen(true);             
                    }
                }
            }
        }

        for(int i = 0; i <=2; i++) {
            for(int k = 0; k <=3 ; k++) {
                if(getFelder()[i][k].getFrei()==false && getFelder()[i+1][k+1].getFrei()==false && getFelder()[i+2][k+2].getFrei()==false && getFelder()[i+3][k+3].getFrei()==false) {
                    if(getFelder()[i][k].getXo()==false && getFelder()[i+1][k+1].getXo()==false && getFelder()[i+2][k+2].getXo()==false && getFelder()[i+3][k+3].getXo()==false){
                        System.out.println("4Spieler X hat gewonnen");
                        g1.setGewonnen(true);
                    } else if(getFelder()[i][k].getXo() && getFelder()[i+1][k+1].getXo() && getFelder()[i+2][k+2].getXo() && getFelder()[i+3][k+3].getXo()) {
                    System.out.println("4Spieler O hat gewonnen");
                    g1.setGewonnen(true);
                    }
                }
            }
        }

        for(int i = 3; i <=5; i++) {
            for(int k = 0; k <=3 ; k++) {
                if(getFelder()[i][k].getFrei()==false && getFelder()[i-1][k+1].getFrei()==false && getFelder()[i-2][k+2].getFrei()==false && getFelder()[i-3][k+3].getFrei()==false) {
                    if(getFelder()[i][k].getXo()==false && getFelder()[i-1][k+1].getXo()==false && getFelder()[i-2][k+2].getXo()==false && getFelder()[i-3][k+3].getXo()==false){
                        System.out.println("5Spieler X hat gewonnen");
                        g1.setGewonnen(true);
                    } else if(getFelder()[i][k].getXo() && getFelder()[i-1][k+1].getXo() && getFelder()[i-2][k+2].getXo() && getFelder()[i-3][k+3].getXo()) {
                    System.out.println("5Spieler O hat gewonnen");
                    g1.setGewonnen(true);
                    }
                }
            }
        }
    }

    public void setFelder(Feld[][] felder) {
        this.felder = felder;
    }
    public Feld[][] getFelder() {
        return felder;
    }

    public void setS1(Spieler s1) {
        this.s1 = s1;
    }

    public Spieler getS1() {
        return s1;
    }
    
    public void setG1(Gewonnen g1) {
        this.g1 = g1;
    }
    public Gewonnen getG1() {
        return g1;
    }
    
}
