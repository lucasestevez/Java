package Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Geometry_Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digte: 1 - Plana e 2 - Espacial");
        System.out.print("Informe se a figura é plana ou espacial: ");
        int idFigure = sc.nextInt();
        figure(sc, idFigure);

    }

    private static void figure(Scanner sc, int idFigure) {
        String verify; double[] array = new double[2];
        DecimalFormat df = new DecimalFormat("0.00");
        int id;
        if(idFigure > 2 || idFigure < 1) {
            System.out.println("Figura informada não existente, tente novamente");
        }else if(idFigure == 1){
            System.out.println("Digite: 1 - Quadrado, 2 - Triângulo, 3 - Retângulo, 4 - Trapézio, 5 - Losangulo e 6 - Círculo");
            System.out.print("Informe a forma geométrica: ");
            id = sc.nextInt();
            calculateFLat(id,sc,array);
        }else {
            System.out.print("A figura espacial é um poliedro regular(Sim ou Não): ");
            verify = sc.next();
            if (verifySN(verify)) {
                System.out.println("Digite: 1 - Hexaedro, 2 - Tetraedro, 3 - Dodecaedro, 4 - Octaedro, 5 - Icosaedro, " +
                        "6 - Prisma e 7 - Pirâmide");
            } else {
                System.out.println("Digite: 1 - Paralelepípedo, 2 - Cone, 3 - Cilíndro, 4 - Esfera");
            }
            System.out.print("Informe a forma geométrica: ");
            id = sc.nextInt();
            calculateSolid(id,verify,sc,array);
        }
        if (idFigure == 1){
            System.out.println("---Resultado---");
            System.out.println("Área: "+df.format(array[0]));
            System.out.println("Perímetro: "+df.format(array[1]));
        }else {
            System.out.println("---Resultado---");
            System.out.println("Área: "+df.format(array[0]));
            System.out.println("Volume: "+df.format(array[1]));
        }
    }

    private static boolean verifySN(String verify) {
        return verify.equals("Sim") || verify.equals("sim");
    }

    public static void calculateFLat(int id, Scanner sc, double[] array) {
        double A , P; String verify;
        if (id == 1){
            System.out.print("Informe o valor do lado: ");
            double l = sc.nextDouble();
            A = l * l; P = 4*l; array[0] = A; array[1] = P;
        } else if (id == 2) {
            System.out.println("1 - Retângulo, 2 - Equilátero, 3 - Isósceles, 4 - Escaleno");
            System.out.print("Informe o tipo de triângulo: ");
            int idTr = sc.nextInt();
            if(idTr == 1){
                System.out.print("Informe o valor da base: ");
                double l1 = sc.nextDouble();
                System.out.print("Informe o valor da altura: ");
                double l2 = sc.nextDouble();
                A = l1 * l2 / 2;
                System.out.print("Informe o valor do último lado: ");
                double l3 = sc.nextDouble();
                P = l1*l2*l3; array[0] = A; array[1] = P;
            } else if (idTr == 2) {
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = Math.sqrt(3)/4*Math.pow(l,2); P = 3*l; array[0] = A; array[1] = P;
            } else if (idTr == 3) {
                System.out.print("Informe o valor do lado da base: ");
                double l1 = sc.nextDouble();
                System.out.print("Informe o valor de um dos lados: ");
                double l2 = sc.nextDouble();
                double h = Math.sqrt(l2 * l2 - l1 * l1 / 2);
                A = l1 * h / 2;
                System.out.print("Informe o valor do último lado: ");
                double l3 = sc.nextDouble();
                P = l1*l2*l3; array[0] = A; array[1] = P;
            }else {
                System.out.print("Informe o valor de um lado: ");
                double l1 = sc.nextDouble();
                System.out.print("Informe o valor do outro lado: ");
                double l2 = sc.nextDouble();
                System.out.print("Informe o ângulo entre esses lados(30,45,60): ");
                int ang = sc.nextInt();
                if (ang == 30){
                    A = (double) 1/2*l1*l2*1/2;
                } else if (ang == 45) {
                    A = (double) 1/2*l1*l2*Math.sqrt(2)/2;
                }else {
                    A = (double) 1/2*l1*l2*Math.sqrt(3)/2;
                }
                System.out.print("Informe o valor do último lado: ");
                double l3 = sc.nextDouble();
                P = l1*l2*l3; array[0] = A; array[1] = P;
            }
        } else if (id == 3) {
            System.out.print("Informe a base: ");
            double b = sc.nextDouble();
            System.out.print("Informe a altura: ");
            double h = sc.nextDouble();
            A = b * h; P = 2 * (b + h); array[0] = A; array[1] = P;
        } else {
            if (id == 4) {
                System.out.print("Tem a base Maior e Menor: ");
                verify = sc.next();
                if(verifySN(verify)){
                    System.out.print("Informe a base maior: ");
                    double B = sc.nextDouble();
                    System.out.print("Informe a base menor: ");
                    double b = sc.nextDouble();
                    System.out.print("Informe a altura: ");
                    double h = sc.nextDouble();
                    A = (B + b) * h / 2;
                    System.out.print("Informe o lado 1: ");
                    double l1 = sc.nextDouble();
                    System.out.print("Informe a lado 2: ");
                    double l2 = sc.nextDouble();
                    P = B + b + l1 + l2;
                }else {
                    System.out.print("Informe a base média: ");
                    double bm = sc.nextDouble();
                    System.out.print("Informe a base existente: ");
                    double b = sc.nextDouble();
                    double B = bm * 2 /b;
                    System.out.print("Informe a altura: ");
                    double h = sc.nextDouble();
                    A = (B + b) * h / 2;
                    System.out.print("Informe o lado 1: ");
                    double l1 = sc.nextDouble();
                    System.out.print("Informe a lado 2: ");
                    double l2 = sc.nextDouble();
                    P = B + b + l1 + l2;
                }
            } else {
                if (id == 5) {
                    System.out.print("Informe a diagonal maior: ");
                    double D = sc.nextDouble();
                    System.out.print("Informe a diagonal menor: ");
                    double d = sc.nextDouble();
                    A = D * d / 2;
                    System.out.print("Informe o valor do lado: ");
                    double l = sc.nextDouble();
                    P = 4 * l;
                }else{
                    System.out.print("Informe o raio: ");
                    double ray = sc.nextDouble();
                    A = 3.14 * Math.pow(ray,2); P = 2 * 3.14 * ray;
                }
            }
            array[0] = A;
            array[1] = P;
        }
    }

    public static void calculateSolid(int id, String verify, Scanner sc, double[] array){
        double A, V ;
        if(verifySN(verify)){
            if(id == 1){
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = 6 * Math.pow(l,2); V = Math.pow(l,3); array[0] = A; array[1] = V;
            } else if (id == 2) {
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = 4 * Math.pow(l,2) * Math.sqrt((double) 3 / 4); V = Math.pow(l,3) * Math.sqrt(2) / 12;
                array[0] = A; array[1] = V;
            } else if (id == 3) {
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = 3 * Math.sqrt(25) + 10 + Math.sqrt(5 * Math.pow(l,2)); V = (double) 1 / 4 * (15 + 7 * Math.sqrt(5)) * Math.pow(l,3);
                array[0] = A; array[1] = V;
            } else if (id == 4) {
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = 2 * Math.pow(l,2) * Math.sqrt(3); V = (double) 1 / 3 * Math.pow(l,3) * Math.sqrt(2);
                array[0] = A; array[1] = V;
            } else if (id == 5){
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                A = 5 * Math.sqrt(3 * Math.pow(l,2)) ; V = (double) 5 / 12 * (3 + Math.sqrt(5)) * Math.pow(l,3);
                array[0] = A; array[1] = V;
            } else if (id == 6) {
                System.out.print("Informe o valor do lado: ");
                double l = sc.nextDouble();
                System.out.print("Informe o número de lados: ");
                double n = sc.nextDouble();
                System.out.print("Informe o valor da altura: ");
                double h = sc.nextDouble();
                double Al = n * l;
                System.out.println("1 - Triângular,  2 - Quadrangular, 3 - Pentagonal, 4 -  Hexagonal, 5 - Heptagonal, 6 - Octagonal");
                System.out.print("Informe o tipo de prisma: ");
                int idBase = sc.nextInt(); double Ab;
                Ab = getBase(sc, idBase);
                A = Al + 2 * Ab ; V = Ab * h; array[0] = A; array[1] = V;
            }else {
                System.out.print("Informe o valor da base: ");
                double b = sc.nextDouble();
                System.out.print("Informe o número de lados: ");
                double n = sc.nextDouble();
                System.out.print("Informe o valor da altura: ");
                double h = sc.nextDouble();
                double Al = n * (b * h / 2);
                System.out.println("1 - Triângular,  2 - Quadrangular, 8 - Retângular");
                System.out.print("Informe o tipo de triângulo: ");
                int idBase = sc.nextInt(); double Ab;
                Ab = getBase(sc, idBase);
                A = Al + Ab; V = Ab * h / 3; array[0] = A; array[1] = V;
            }

        } else {
            if (id == 1) {
                System.out.print("Informe o valor de a: ");
                double a = sc.nextDouble();
                System.out.print("Informe o valor de b: ");
                double b = sc.nextDouble();
                System.out.print("Informe o valor de c: ");
                double c = sc.nextDouble();
                A = 2 * a * b + 2 * b * c + 2 * a * c; V = a * b * c; array[0] = A; array[1] = V;
            } else if (id == 2) {
                System.out.print("Informe o valor do raio: ");
                double ray = sc.nextDouble();
                System.out.print("Informe o valor da geratriz: ");
                double g = sc.nextDouble();
                System.out.print("Informe o valor da altura: ");
                double h = sc.nextDouble();
                A = 3.14 * ray * (g + ray); V = (double) 1 / 3 * 3.14 * Math.pow(ray,2) * h; array[0] = A; array[1] = V;
            } else if (id == 3) {
                System.out.print("Informe o valor do raio: ");
                double ray = sc.nextDouble();
                System.out.print("Informe o valor da altura: ");
                double h = sc.nextDouble();
                A = 2 * (3.14 * Math.pow(ray,2)) + 2 * (3.14 * ray * h); V = 3.14 * Math.pow(ray,2) * h; array[0] = A; array[1] = V;
            } else {
                System.out.print("Informe o valor do raio: ");
                double ray = sc.nextDouble();
                A = 4 * 3.14 * Math.pow(ray,2); V = 4 * 3.14 * Math.pow(ray,3) / 3; array[0] = A; array[1] = V;
            }

        }
        array[0] = A; array[1] = V;
    }

    private static double getBase(Scanner sc, int idBase) {
        double Ab;
        if (idBase == 1){
            System.out.print("Informe o valor da base: ");
            double b = sc.nextDouble();
            System.out.print("Informe o valor da altura: ");
            double h2 = sc.nextDouble();
            Ab = b * h2 / 2;
        } else if (idBase == 2) {
            System.out.print("Informe o valor do lado: ");
            double l2 = sc.nextDouble();
            Ab = Math.pow(l2,2);
        } else if (idBase == 3) {
            System.out.print("Informe o valor do lado: ");
            double l2 = sc.nextDouble();
            System.out.print("Informe a apótema: ");
            double a = sc.nextDouble();
            Ab = 5 * l2 * a;
        } else if (idBase == 4) {
            System.out.print("Informe o valor do lado: ");
            double l2 = sc.nextDouble();
            Ab = 3 * Math.pow(l2,2) * Math.sqrt(3) / 2;
        } else if (idBase == 5) {
            System.out.print("Informe o valor do lado: ");
            double l2 = sc.nextDouble();
            System.out.print("Informe a apótema: ");
            double a = sc.nextDouble();
            Ab = 7 * l2 * a / 2;
        }else if(idBase == 7) {
            System.out.print("Informe o valor do lado: ");
            double l2 = sc.nextDouble();
            System.out.print("Informe a apótema: ");
            double a = sc.nextDouble();
            Ab = 4 * l2 * a;
        }else {
            System.out.print("Informe a base: ");
            double b = sc.nextDouble();
            System.out.print("Informe a altura: ");
            double h = sc.nextDouble();
            Ab = b * h;
        }
        return Ab;
    }

}
