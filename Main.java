public class Main{

    public static void main(String[] args) {
        int escolha = Menu.menu();

        if(escolha == 1){
            Menu.controleAcesso();
        }

        else if(escolha == 2){
            return;
        }

        else{
            System.out.print("Você digitou uma opção inválida.\n");
            main(args);
        }    
    }
}


