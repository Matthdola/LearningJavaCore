public class Test {
    public static void main(String[] args) {
        Person p = new Person("Matthias", "DOLA", "matthiasdola@gmail.com");
        System.out.println(p);
        Person p1 = new Person("Fons", "DE WOLF", "fons.dola@gmail.com");
        Person p2 = new Person("Anne-Marie", "DAIS", "parisiendola@gmail.com");

        Office office = new Office(p, p1, p2);
        System.out.println(office);

    }
}