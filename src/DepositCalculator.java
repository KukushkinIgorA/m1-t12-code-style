import java.util.Scanner;

public class DepositCalculator {

    public static final double DEPOSIT_PERCENT = 0.06;
    public static final int COUNT_MONTH_IN_YEAR = 12;

    double calculateComplexPercent(double depositAmmount, int depositPeriod ) {
        double depositOutAmmount = depositAmmount * Math.pow((1 + DEPOSIT_PERCENT / COUNT_MONTH_IN_YEAR), COUNT_MONTH_IN_YEAR * depositPeriod);
        return roundPercent(depositOutAmmount);
    }

    double calculateSimplePercent(double depositAmmount, int depositPeriod) {
        double depositOutAmmount = depositAmmount + depositAmmount * DEPOSIT_PERCENT * depositPeriod;
        return roundPercent(depositOutAmmount);
    }

    double roundPercent(double depositOutAmmount) {
       double ScaLe = Math.pow(10, 2);
       return Math.round(depositOutAmmount*ScaLe)/ScaLe;
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;
        int depositAmmount;
        double depositOutAmmount = 0;

        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            depositOutAmmount = calculateSimplePercent(depositAmmount, depositPeriod);
        } else if (depositType == 2) {
            depositOutAmmount = calculateComplexPercent(depositAmmount, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmmount + " за " + depositPeriod + " лет превратятся в " + depositOutAmmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
