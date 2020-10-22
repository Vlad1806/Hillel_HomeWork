public class Car {

    public  int volume;
    public  float tank_balance;
    public  int consumption_100;

    public Car(int volume, float tank_balance, int consumption_100) {
        this.volume = volume;
        this.tank_balance = tank_balance;
        this.consumption_100 = consumption_100;
    }

    public float full_tank(){
        float k = volume - tank_balance;
        tank_balance = tank_balance + k;
        return k;
   }

   public float balance(int km){
       float one_km = one_km();
       float liter_for_all_km = km * consumption_100 / (float)100;
       if (tank_balance - liter_for_all_km < 0){
           float diif_ = liter_for_all_km - tank_balance;
           float q = liter_for_all_km - diif_;
          tank_balance = tank_balance - q;

           float k = full_tank();
           tank_balance = tank_balance = tank_balance - diif_;
       }else {
       tank_balance = tank_balance - liter_for_all_km;
       }
       return tank_balance;
   }

   public float one_km(){
        return (float)consumption_100 / (float)100;
   }

   public float count_refueling(int km){
        float one_km = one_km();
        float max_km = km - (tank_balance * 100 ) / consumption_100;
        float max_fuel = max_km * one_km;

        if (max_fuel <= 0){
            max_fuel = 0;
        }
      return max_fuel;
   }
}
class Run {
    public static void main(String[] args) {
        int distance = 475;

        Car c = new Car(93,34,25);
        System.out.println("Point a - Odessa, point b - Kiev (distance - 474.5 km)");
        System.out.println("First stop at Crooked Lake 179km:");
        System.out.println(" ");
        int lake = 179;
        System.out.println("Сколько нужно дозаправить: " + c.count_refueling(lake));
        System.out.println("Остаток топлива после 179km : " + c.balance(lake));
        System.out.println(" ");
        System.out.println("Second stop at Zhashkov 152km after crooked lake:");
        int zhashkov = 152;
        System.out.println(" ");
        System.out.println("Сколько нужно дозаправить: " + c.count_refueling(zhashkov));
        System.out.println("Остаток топлива после 152km : " + c.balance(zhashkov));
        int ress_way = distance -(lake + zhashkov);
        System.out.println("Остаток топлива после " + ress_way + "km : " + c.balance(ress_way));
        float k = (float) (distance * c.consumption_100) / 100;
        System.out.println("Неодходимое количество бензина: " + k + " L" + " Цена: " + k * 21.97);
    }
}