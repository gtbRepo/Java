package core;

public class VersionAndGreet
{
   VersionAndGreet()
   {
       String programName = "Weather forecast";
       String programVersion = "1.0.14";
       System.out.println("\nProgram " + programName + " wersja " + programVersion);
       System.out.println("\nPragnę zaprezentować aplikację do pobierania danych meteorologicznych");
       System.out.println("z przykładowej strony internetowej.");
       System.out.println("Głównym komponentem wykorzystanym w programie jest web scraper,");
       System.out.println("którego celem jest pobranie zarówno obecnych danych pogodowych");
       System.out.println("jak również krótko- i długoterminowej prognozy dla miasta Kraków.\n"
                           + "Dane zostały pobrane z portalu pogoda.interia.pl\n");
   }
}
