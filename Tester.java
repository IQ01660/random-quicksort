public class Tester {

    private static Generate generator = new Generate();

    private static String[] input_types = new String[3];

    // creating the two sorters
    private static RandomQuickSort randSorter = new RandomQuickSort();
    private static DeterministicQuickSort detSorter = new DeterministicQuickSort();
    private static ImprovedQuickSort mixedSorter = new ImprovedQuickSort();
    public static void main(String[] args) {
        

        input_types[0] = "random";
        input_types[1] = "p_sorted";
        input_types[2] = "m_sorted";

        // getting the average runtimes for the plot
        testAverageRuntimes();

        // seperate the text in terminal
        seperate();

        // test the mixed quicksorter
        testImprovedQS();

        seperate();
        // getting the variance

        //RQS - random input
        System.out.println(variance(randSorter, 500000, input_types[0]));
        //DQS - random input
        System.out.println(variance(detSorter, 500000, input_types[0]));
        //RQS - p_sorted input
        System.out.println(variance(randSorter, 100000, input_types[1]));
        //DQS - p_sorted input
        System.out.println(variance(detSorter, 100000, input_types[1]));
        //RQS - m_sorted input
        System.out.println(variance(randSorter, 10000, input_types[2]));
        //DQS - m_sorted input
        System.out.println(variance(detSorter, 10000, input_types[2]));
    }

    private static void testAverageRuntimes() {
        /**
         * RANDOM INPUT
         */
        System.out.println("====================");
        System.out.println("Average runtime for " + input_types[0] + " input");

        System.out.println("RandSorter");

        for (int input_size = 100000; input_size <= 1000000; input_size += 100000)
        {
            System.out.println(input_size + "::" + averageRuntime(randSorter, input_size, input_types[0]));
        }

        System.out.println("--------------------");

        System.out.println("DetSorter");

        for (int input_size = 100000; input_size <= 1000000; input_size += 100000)
        {
            System.out.println(input_size + "::" + averageRuntime(detSorter, input_size, input_types[0]));
            
        }

        /**
         * PARTIALLY SORTED INPUT
         */
        System.out.println("====================");
        
        System.out.println("====================");
        System.out.println("Average runtime for " + input_types[1] + " input");

        System.out.println("RandSorter");

        for (int input_size = 100000; input_size <= 1000000; input_size += 100000)
        {
            System.out.println(input_size + "::" + averageRuntime(randSorter, input_size, input_types[1]));
        }

        System.out.println("--------------------");

        System.out.println("DetSorter");

        for (int input_size = 10000; input_size <= 170000; input_size += 10000)
        {
            
            System.out.println(input_size + "::" + averageRuntime(detSorter, input_size, input_types[1]));
            
        }

        /**
         * MOSTLY SORTED INPUT
         */

        System.out.println("====================");

        System.out.println("====================");
        System.out.println("Average runtime for " + input_types[2] + " input");

        System.out.println("RandSorter");

        for (int input_size = 100000; input_size <= 1000000; input_size += 100000)
        {
            System.out.println(input_size + "::" + averageRuntime(randSorter, input_size, input_types[2]));
        }

        System.out.println("--------------------");

        System.out.println("DetSorter");

        for (int input_size = 10000; input_size <= 20000; input_size += 1000)
        {
            System.out.println(input_size + "::" + averageRuntime(detSorter, input_size, input_types[2]));
        }

        System.out.println("====================");
    }

    private static double variance(QuickSort sorter, int input_size, String input_type) {
        int trialNum = 100;
        long runtimeSum = 0;
        long[] runtimes = new long[trialNum];

        for (int i = 0; i < trialNum; i++) {
            int[] arr;
            if (input_type.equals("random")) {
                arr = generator.generateRandomInput(input_size);
            }
            else if (input_type.equals("p_sorted")) {
                arr = generator.generatePartiallySortedInput(input_size);
            }
            else {
                arr = generator.generateMostlySortedInput(input_size);
            }

            sorter.sort(arr);
            runtimes[i] = sorter.getCounter();
            //System.out.println(sorter.getCounter());
            runtimeSum += sorter.getCounter();
        }

        long average = runtimeSum / trialNum;

        //calculating the empirical variance
        long diff_sum = 0;

        for (int i = 0; i < runtimes.length; i++) {
            diff_sum += (runtimes[i] - average)*(runtimes[i] - average);
        }

        double variance = diff_sum/ ( (double) trialNum - 1);
        System.out.println(variance);

        //normalized variance returned - squared coeff of variation
        return variance / (average * average);
    }

    private static long averageRuntime(QuickSort sorter, int input_size, String input_type)
    {
        long runtimeSum = 0;
        int trialNum = 10;

        for (int i = 0; i < trialNum; i++) {
            //creating an array for one specific case with input size n
            int[] arr;
            if (input_type.equals("random")) {
                arr = generator.generateRandomInput(input_size);
            }
            else if (input_type.equals("p_sorted")) {
                arr = generator.generatePartiallySortedInput(input_size);
            }
            else {
                arr = generator.generateMostlySortedInput(input_size);
            }

            sorter.sort(arr);
            runtimeSum += sorter.getCounter();
        }

        return (runtimeSum / trialNum);
    }

    private static void testImprovedQS() {
        System.out.println("====================");
        System.out.println("Average runtime for " + input_types[0] + " input");

        System.out.println("Improved QuickSort");

        for (int input_size = 100000; input_size <= 1000000; input_size += 100000)
        {
            System.out.println(input_size + "::" + averageRuntime(mixedSorter, input_size, input_types[0]));
        }

        System.out.println("Average runtime for " + input_types[1] + " input");

        System.out.println("Improved QuickSort");

        for (int input_size = 10000; input_size <= 170000; input_size += 10000)
        {
            System.out.println(input_size + "::" + averageRuntime(mixedSorter, input_size, input_types[1]));
        }

        System.out.println("Average runtime for " + input_types[2] + " input");

        System.out.println("Improved QuickSort");

        for (int input_size = 10000; input_size <= 20000; input_size += 1000)
        {
            System.out.println(input_size + "::" + averageRuntime(mixedSorter, input_size, input_types[2]));
        }
    }

    public static void arrayPrint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void seperate() {
        System.out.println("///////////////////////");
        System.out.println("///////////////////////");
        System.out.println("///////////////////////");
    }
}
