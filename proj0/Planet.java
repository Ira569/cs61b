public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,double yV, double m, String img){
         xxPos=xP;
         yyPos=yP;
         xxVel=xV;
         yyVel=yV;
         mass=m;
         imgFileName=img;

    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public  double calcDistance(Planet p){
        double distance;
        distance=Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
        return distance;
    }

    public double calcForceExertedBy(Planet p){
        double force=0;
        force = G*this.mass*p.mass/(calcDistance(p)*calcDistance(p));
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double forceX=0;
        forceX = calcForceExertedBy(p)*(p.xxPos-this.xxPos)/calcDistance(p);
        return forceX;
    }

    public double calcForceExertedByY(Planet p){
        double forceY=0;
        forceY = calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
        return forceY;
    }

    
    public double calcNetForceExertedByX(Planet[] p){
        double forceX=0.0;
        for(int i=0;i<p.length;i++){
            if (p[i].equals(this))
                continue;
            forceX+=calcForceExertedByX(p[i]);
        }
        
        return forceX;
    }

    public double calcNetForceExertedByY(Planet[] p){
        double forceY=0.0;
        for(int i=0;i<p.length;i++){
            if (p[i].equals(this))
                continue;
            forceY+=calcForceExertedByY(p[i]);
        }
        
        return forceY;
    }

    public void update(double dt,double fX,double fY){
        double aX=0.0,aY=0.0;
        aX=fX/this.mass;
        aY=fY/this.mass;
        this.xxVel=this.xxVel+dt*aX;
        this.yyVel=this.yyVel+dt*aY;
        this.xxPos=this.xxPos+dt*this.xxVel;
        this.yyPos=this.yyPos+dt*this.yyVel;
    }

    public void draw(){
    StdDraw.picture(xxPos,yyPos, "images/"+imgFileName);
    

    }
}