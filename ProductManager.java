class Product {
    private String productName;
    private int productID;
    private double[] prices; // Pole cien potravin... pole spoznas podla '[]'

    // Konstruktor ktory inicializuje "atributy triedy" inak povedane clenske
    // premenne a pole, pripravuje triedu na jej funkcnost
    // Konstruktor sa vola pri vytvarani objektu resp. objektov cez operator new
    // Product(....)
    // this vrati adresu objektu kde je tento objekt alokovany
    public Product(String productName, int productID, double[] prices) {
        this.productName = productName;
        this.productID = productID;
        this.prices = prices;
    }

    public void DisplayInfo() {
        System.out.println("Product: " + productName); // vypise text a skoci na novy riadok
        System.out.println("Product ID: " + productID);

        System.out.print("Prices: ["); // print vypisuje na ten isty riadok
        for (double price : prices) {
            System.out.print(price + ",");
        }
        System.out.print("]");
        System.out.println(); // dostanie sa na novy riadok kvoli lepsiemu vypisu
    }

}

public class ProductManager {

    public static double findAverageSales(int[] sales, int start, int end) {
        int sum = 0;
        // vytvori sa suma z daneho rangu, ktory prisiel v parametroch
        for (int i = start; i <= end; i++) {
            sum += sales[i];
        }
    
        // Calculate and return the average for the specified period
        int cntWeeks = (end - start) + 1; // indexujeme mesiace od 0 a teda ak mame napr. 1 mesiac mame 3 - 0, co predstavuje len 3 tyzdne preto dame + 1
        return (double) sum / cntWeeks;
    }
    
    public static void sortPrices(double[] prices) {
        int n = prices.length;
        
        // na to aby sa mohol vykonat vonkajsi cyklus jeden krat, sa musi vnutorny cyklus vykonat napr. 10x
        // potom sa prejde na dalsiu iteraciu vonkajsieho cyklu kde opat vnutorny sa musi vykonat 10x
        for (int i = 0; i < n - 1; i++) {  // pocet prechodov cez pole (tu zoberieme jeden prvok a ideme ho porovnavat s ostatnymi)
            // ten prvy zoberieme a musime prejst vsetky ostatne, vsimni si ze int i ostava rovnake zatial co sa porovnava s j + 1
            // teda prvy prvok i = 0, sa porovna nasledne najskor s j -> 0 + 1, j -> 0 + 2, teda i != j
            for (int j = 0; j < n - 1 - i; j++) { 
                if (prices[j] > prices[j + 1]) {  
                    // Výmena prvkov
                    double temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                }
            }
        }
    }

    public static void CreateAndDiplayMatrix()
    {
        int[][] matrix = new int[5][5];

       // inicializujeme matrix nahodnymi hodnotami
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100); // od 0 po 99
            }
        }

        // zobrazenie matrixu
        System.out.println("5x5 Matrix:");
        for (int[] row : matrix) { // berieme cely riadok 
            for (int value : row) { // vypisujeme honoty z riadkov
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Product[] products = new Product[10]; // vytvorenie pola o velkosti 10 uzivatelsky definovaneho datoveho typu
                                              // Product ( Product je tu trieda ), toto pole drzi 10 objekto

        // range based pole, rozsahom definovane pole ... toto sa vykona 10 krat ale
        // pozor ideme od 0 po 9
        // lebo do buniek v poli vstupujeme od hodnoty '0', ak by sa nam podarilo dostat
        // i je rovne 10 (padnie aplikacia)
        for (int i = 0; i < 10; i++) { // polia sa indexuju alebo inak povedane sa do nich pozerame tak ze zaciname od
                                       // 0, ak mam teda pole o velkosti 10 prvky bude mat od 0 po 9
            products[i] = new Product("Product " + (i + 1), i + 1, new double[] { 1, 2, 3 });
        }

        // products je pole ktore ma velkost 10, tento cyklus automaticky zisti velkost
        // pola a vykona sa 10 krat
        // zakazdym vytiahne z pola iny objekt, pricom tiez prechadza od 0 po 9, no
        // tento zapis nam umoznuje
        // krajsi zapis a lahsiu citatelnost, v skutocnosti tento foreach loop sa
        // prelozi do velmi podobneho cyklu
        // ktory sme napisali vyssie

        int productNumber = 1;
        for (Product product : products) {

            System.out.println("Product " + productNumber);
            productNumber++;
            product.DisplayInfo();
        }

        int[] weeklySales = new int[40];
        for (int i = 0; i < weeklySales.length; i++) {
            weeklySales[i] = (int) (Math.random() * 100); // NAhodne cislo vygenerovane od 0 do 99
        }

        System.out.print("Weekly Sales: [");
        for (int sale : weeklySales) {
            System.out.print(sale + ", ");
        }
        System.out.print("]");
        System.out.println(); // dostanie sa na novy riadok kvoli lepsiemu vypisu
        
        // Rozdelenie predajov na mesiace (4 tyzdne na mesiac)
        int[] monthlySales = new int[12]; // 12 tyzdnov (3 mesiace po 4 tyzdne)

        // Kopirovanie predajov z weeklySales do monthlySales
        for (int i = 0; i < 12; i++) {
            monthlySales[i] = weeklySales[i]; // Kopirovanie predaja pre kazdy tyzden
        }

        System.out.println("Monthly Sales:");
        for (int month = 0; month < 3; month++) { // prvy cyklus sa opakuje podla poctu mesiacov co je 3 krat ( 3
                                                  // mesiace )
            System.out.print("Month " + (month + 1) + ": [");

            // dalsi cyklus (vnoreny) spravi vzdy pre jednu iteraciu vonkajsieho cyklu 4
            // opakovania, teda 1x mesiac -> 4x zopakuje sa toto tu
            // tu si vsimni ze int week, je pomocna premenna pomocou ktorej sa nastavujeme
            // na spravne indexy
            // 1. prva iteracia vonkajcieho cyklu je int week vo vnutornom cykle nastaveni
            // na -> 0
            // 2. druha iteracia vonkajcieho cyklu je int week vo vnutornom cykle nastaveni
            // na -> 4
            // 3. tretia iteracia vonkajcieho cyklu je int week vo vnutornom cykle nastaveni
            // na -> 8
            for (int week = month * 4; week < (month + 1) * 4; week++) {
                System.out.print(monthlySales[week] + ",");
            }
            System.out.print("]");
            System.out.println(); // Nový riadok po zobrazení všetkých týždňov pre mesiac
        }

        System.out.println("Average Sales for Month 2: " + findAverageSales(weeklySales, 4, 7));

        double[] arrayToSort = new double[10];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = (int) (Math.random() * 100); // NAhodne cislo vygenerovane od 0 do 99
        }
        sortPrices(arrayToSort);

        System.out.print("Sorted Prices: [");
        for (double price : arrayToSort) {
            System.out.print(price + ", ");
        }
        System.out.print("]");
        System.out.println(); // novy riadok

        CreateAndDiplayMatrix();
    }
}
