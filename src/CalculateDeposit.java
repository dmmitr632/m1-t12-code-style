import java.util.Scanner;


public class CalculateDeposit {
    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale)/ Scale;
    }

    void doImportantJob() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDouble = 0;

        if (action == 1) {
            outDouble = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            outDouble = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDouble);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doImportantJob();
    }


}
