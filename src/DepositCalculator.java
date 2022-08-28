import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateDepositResult() {

        Scanner scanner = new Scanner(System.in);

        int depositPeriod;
        int userAction;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада: " + "\n"
                + "1 - вклад с обычным процентом," + "\n"
                + "2 - вклад с капитализацией");

        userAction = scanner.nextInt();

        double result = 0;
        if (userAction == 1) {
            result = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (userAction == 2) {
            result = calculateComplexPercent(amount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositResult();
    }

}
