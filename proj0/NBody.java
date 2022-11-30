public  class NBody{

    public static double readRadius(String filename){
        In in = new In(filename);
        int NumOfPlanet = in.readInt();
		double Radius = in.readDouble();

        return Radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int NumOfPlanet = in.readInt();
		double Radius = in.readDouble();
        Planet[] pArrey=new Planet[NumOfPlanet];
        for (int i=0;i<NumOfPlanet;i++)
        {   
            double xxpos=in.readDouble();
            double yypos=in.readDouble();
            double xxvel=in.readDouble();
            double yyvel=in.readDouble();
            double mass=in.readDouble();
            String imgFilename=in.readString();
            Planet p=new Planet(xxpos, yypos, xxvel, yyvel, mass, imgFilename);
            pArrey[i]=p;
        }
        return pArrey;
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        Planet[] pArrey= readPlanets(filename);
        double Radius=readRadius(filename);
        StdDraw.enableDoubleBuffering();
        double time=0;
        int waitTimeMilliseconds=10;
        while (time<T)
        {   StdDraw.setScale(-Radius, Radius);
            StdDraw.clear();
            double[] xForceArrey=new double[pArrey.length];
            double[] yForceArrey=new double[pArrey.length];
            for (int i=0;i<pArrey.length;i++){
                xForceArrey[i]=pArrey[i].calcNetForceExertedByX(pArrey);
                yForceArrey[i]=pArrey[i].calcNetForceExertedByY(pArrey);
            }
            for (int i=0;i<pArrey.length;i++){
                pArrey[i].update(dt,xForceArrey[i], yForceArrey[i]);
            }
            StdDraw.picture(0, 0,"images/starfield.jpg");
            for (int i=0;i<pArrey.length;i++){
                pArrey[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(waitTimeMilliseconds);
            time +=dt;
        }
        StdOut.printf("%d\n", pArrey.length);
        StdOut.printf("%.2e\n", Radius);
    for (int i = 0; i < pArrey.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        pArrey[i].xxPos, pArrey[i].yyPos, pArrey[i].xxVel,
        pArrey[i].yyVel, pArrey[i].mass, pArrey[i].imgFileName);   
}

    }

}