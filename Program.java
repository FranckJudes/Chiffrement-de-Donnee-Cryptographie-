import java.util.Scanner;

public class Program{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;
        do{

          System.out.println("\t\t---------------CRYPTOGRAPHIE AFFINE-------------------");  

          System.out.println("\t\t 1- Chiffrement Affine"); 
          System.out.println("\n");
          System.out.println("\t\t 2- Dechiffrement Affine"); 
          System.out.println("\n");
          System.out.println("\t\t 3-Cryptanalyse Affine"); 
          System.out.println("\n");
          System.out.println("\t\t 4-Quitter"); 
          System.out.println("\n");
          choix = sc.nextInt();
          sc.nextLine();
          if (choix == 1) {
              System.out.println("Entrez le mot Clair a Chiffre : ");
              String MotClair = sc.nextLine();
              System.out.println("Entrez la valeur de A et B (Ax + B) : ");
              int a = sc.nextInt();
              int b = sc.nextInt();
              String Q = chiffrement(MotClair, a ,b);
              System.out.println(" \t Le Mot chiffre est : " +Q);
          }
          if (choix == 2) {
            System.out.println("Entrez le mot Chiffre a Dechiffre : ");
            String MotChiffre = sc.nextLine();
            System.out.println("Entrez la valeur de A et B (Ax + B) : ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            String Q = dechiffrement(MotChiffre, a ,b);
            System.out.println(" \t Le Mot Dechiffre est : " +Q);
        }
        if (choix == 3) {
            System.out.println("Entrez le mot Chiffre : ");
            String MotChiffre = sc.nextLine();
            String Q = cryptanalyse(MotChiffre);  
            System.out.println(Q);
        }
        System.out.println("");
        System.out.println("");
        }while(choix != 4);
    }





     static String chiffrement(String motclair, int g, int h)
	{
        int Nbreaphabet=26;
        String motCrypter="";
            for(int i=0;i<motclair.length();i++)
            {
                    int n = 0;
                    char decrpt = 0;
                    int m=motclair.charAt(i);
                    if(m>96&&m<123)
                    {
                        
                        n=m-97;
                    }
                    if(m>64&&m<91)
                    {
                        
                        n=m-65;
                    }
                    int module= ((g*n)+h)%Nbreaphabet;
                    
                    if(m>96&&m<123)
                    {
                        decrpt=(char)(module+97);
                        motCrypter+=decrpt;
                    }
                    if(m>64&&m<91)
                    {
                        decrpt=(char)(module+65);
                        motCrypter+=decrpt;
                    }
            }
          return motCrypter;
	}

    static int inverse(int a){
        int invA=0;

		for(int j=1;j<27;j++)
		{
			if((a*j)%26==1)
			{
			    invA=j;
			break;
			}
		}
        return invA;
    }

     static String dechiffrement(String motChiffe, int g, int h)
	{
        int Nbreaphabet=26;
        
            String MotClair="";
            for(int i=0;i<motChiffe.length();i++){
                int n = 0;
                char decrpt = 0;
                int m=motChiffe.charAt(i);
                if(m>96&&m<123)
                {
                    n=m-97;
                }
                if(m>64&&m<91)
                {			
                    n=m-65;
                }		
                int inv = inverse(g);

                int module=((inv)*(n-h))%Nbreaphabet;

                if(m>96&&m<123)
                {
                    decrpt=(char)(module+97);
                    MotClair+=decrpt;
                }
                if(m>64&&m<91)
                {
                    decrpt=(char)(module+65);
                    MotClair+=decrpt;
                }
            }
            return MotClair;
	   
    }
    
     static String cryptanalyse(String motChiffe)
	{
        String affstr2="";
        int a[]={1,3,5,7,9,11,15,17,19,21,23,25};
        int count=1;
        
        for(int k=0;k<26;k++)
        {
            for(int l=0;l<12;l++)
            {
                affstr2=affstr2+"A et B Possible = "+count+"\r\na= "+a[l]+" b= "+k+"\r\n";
                affstr2=affstr2+"Mot Possible -----> " + dechiffrement(motChiffe,a[l],k)+"\r\n\r\n";
                count+=1;
            }
        }
	    return affstr2;
	}
}