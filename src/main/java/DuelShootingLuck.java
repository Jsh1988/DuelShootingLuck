package main.java;

public class DuelShootingLuck {

    public static void main(String[] args) {
        double[] x = {0.1, 0.3};
        double[] d = {0.09, 0.02};

        double[][] V = new double[2][11];
        double[][] b = new double[2][11];

        V[0][10] = 1;
        b[0][10] = 10;
        V[1][10] = 0;
        b[0][10] = -1; //no way

        for (int i=9;i>=0;i--){

            double X = x[0] + d[0]*i;
            double Y = x[1] + d[1]*i;

            if (Y > 1 - V[0][i+1]){ //2 shot
                V[1][i] = Y;
                V[0][i] = 1 - Y;
                b[1][i] = i;
                b[0][i] = 10;
            } else {  //2 no shot
                V[1][i] = V[1][i+1];
                V[0][i] = V[0][i+1];
                b[1][i] = b[1][i+1];
                b[0][i] = b[0][i+1];
            }

            if (X > 1 - V[1][i]){ // 1 shot
                V[1][i] = 1 - X;
                V[0][i] = X;
                b[1][i] = 10;
                b[0][i] = i;

            }

        }

        System.out.println(V[0][0] + " " + b[0][0]);
        System.out.println(V[1][0] + " " + b[1][0]);

    }
}
