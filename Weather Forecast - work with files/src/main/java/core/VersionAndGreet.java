package core;

public class VersionAndGreet {
   VersionAndGreet() {
       String programName = "Weather forecast";
       String programVersion = "1.3.0";
       System.out.println("\nProgram " + programName + " wersja " + programVersion);
       System.out.println("""
               \nPragnę zaprezentować aplikację do pobierania danych meteorologicznych"
              z przykładowej strony internetowej.\s
              Głównym komponentem wykorzystanym w programie jest web scraper,
              którego celem jest pobranie zarówno obecnych danych pogodowych
              jak również krótko- i długoterminowej prognozy dla miasta Kraków."
              Dane zostały pobrane z portalu pogoda.interia.pl
              \s""");
   }
}
