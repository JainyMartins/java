package estabelecimento;

import copiadora.Copiadora;
import digitalizadora.Digitalizadora;
import equipamentomultifuncional.EquipamentoMultifuncional;
import impressora.DeskJet;
import impressora.Impressora;

public class Fabrica {
    public static void main (String[] args){
        //Pode representar todos os papéis, ele é tudo - flexibilidade para classe TER MAIS DE UM PAPEL
        EquipamentoMultifuncional em = new EquipamentoMultifuncional();
        Impressora impressora = em;
        Digitalizadora digitalizadora = em;
        Copiadora copiadora = em;

        impressora.imprimir();
        digitalizadora.digitalizar();
        copiadora.copiar();

        //Consegue dizer que é impressora porque ele também implementa impressora
        Impressora impressora2 = new EquipamentoMultifuncional();
        impressora2.imprimir();
    }
}
