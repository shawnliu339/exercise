package com.sran.exercise.pz.b;

import java.util.*;

public class B026 {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        //初始化自动售卖机
        Machine m = new Machine(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        Integer num = sc.nextInt();
        
        //处理购物者信息
        List<Customer> customers = new LinkedList<Customer>();
        for(int i=0; i<num; i++) {
        	Customer customer = new Customer(sc.nextInt(),sc.nextInt(),
        			sc.nextInt(),sc.nextInt(),sc.nextInt());
        	customers.add(customer);
        }
        
        for(Customer customer : customers) {
        	Otsuri o = m.dealBuy(customer);
        	if(o==null) {
        		System.out.println("impossible");
        	} else {
        		System.out.println(o.getCoin500()+" "+o.getCoin100()+" "
        	        	+ o.getCoin50() +" "+ o.getCoin10());
        	        	
        	}
        }
        
    }
	
	
	private static class Machine {
		
		private Integer tonyu=0;
		private Integer conyu=0;
		private Integer otsuri=0;
		
		private Integer zantaka=0;
		private Integer coin10=0;
		private Integer coin50=0;
		private Integer coin100=0;
		private Integer coin500=0;
		
		public Machine(Integer coin500, Integer coin100, Integer coin50,
				Integer coin10) {
			super();
			this.coin10 = coin10;
			this.coin50 = coin50;
			this.coin100 = coin100;
			this.coin500 = coin500;
			this.zantaka = coin10*10 + coin50*50 
	        		+ coin100*100 + coin500*500;
		}
		
		
		
		public Machine() {
			super();
		}

		public Integer getTonyu() {
			return tonyu;
		}



		public void setTonyu(Integer tonyu) {
			this.tonyu = tonyu;
		}



		public Integer getConyu() {
			return conyu;
		}



		public void setConyu(Integer conyu) {
			this.conyu = conyu;
		}



		public Integer getOtsuri() {
			return otsuri;
		}



		public void setOtsuri(Integer otsuri) {
			this.otsuri = otsuri;
		}



		public Integer getZantaka() {
			return zantaka;
		}



		public void setZantaka(Integer zantaka) {
			this.zantaka = zantaka;
		}



		public Integer getCoin10() {
			return coin10;
		}



		public void setCoin10(Integer coin10) {
			this.coin10 = coin10;
		}



		public Integer getCoin50() {
			return coin50;
		}



		public void setCoin50(Integer coin50) {
			this.coin50 = coin50;
		}



		public Integer getCoin100() {
			return coin100;
		}



		public void setCoin100(Integer coin100) {
			this.coin100 = coin100;
		}



		public Integer getCoin500() {
			return coin500;
		}



		public void setCoin500(Integer coin500) {
			this.coin500 = coin500;
		}

		
		public void rollback(Otsuri otsu) {
			coin500 += otsu.getCoin500();
			coin100 += otsu.getCoin100();
			coin50 += otsu.getCoin50();
			coin10 += otsu.getCoin10();
		}
		
		
		public  Otsuri dealBuy(Customer customer) {
			
			Otsuri otsu = new Otsuri();
			Integer otsuri = customer.tonyu - customer.konyu;
			otsu.setOtsuri(otsuri);
			if(otsuri>zantaka)
				return null;
			
			while(otsuri != 0) {
				
				String money = "0";
				if(otsuri>=500)
					money = "500+";
				if(otsuri>100 && otsuri<500)
					money = "100+";
				if(otsuri==100)
					money = "100";
				if(otsuri>=50 && otsuri<100)
					money = "50+";
				if(otsuri>=10 && otsuri<50)
					money = "10+";
				
				switch(money) {
				
					case "500+":
						if(coin500 > 0) {
							otsu.setCoin500(otsu.getCoin500()+1);
							otsuri -= 500;
							coin500 -= 1;
						} else if(coin100>=5) {
							otsu.setCoin100(otsu.getCoin100()+5);
							otsuri -= 500;
							coin100 -= 5;
						} else {
							rollback(otsu);
							return null;
						}
						break;
						
					case "100+":
						if(coin100 > 0) {
							otsu.setCoin100(otsu.getCoin100()+1);
							otsuri -= 100;
							coin100 -= 1;
						} else {
							rollback(otsu);
							return null;
						}
						break;
						
					case "100":
						if(coin100 > 0) {
							otsu.setCoin100(otsu.getCoin100()+1);
							otsuri -= 100;
							coin100 -= 1;
						} else if(coin50>0 && coin10>=5) {
							otsu.setCoin50(otsu.getCoin50()+1);
							otsu.setCoin10(otsu.getCoin10()+5);
							otsuri -= 100;
							coin50 -= 1;
							coin10 -= 5;
						} else {
							rollback(otsu);
							return null;
						}
						break;
						
					case "50+":
						if(coin50 > 0) {
							otsu.setCoin50(otsu.getCoin50()+1);
							otsuri -= 50;
							coin50 -= 1;
						} else if(coin10>=5) {
							otsu.setCoin10(otsu.getCoin10()+5);
							otsuri -= 50;
							coin10 -= 5;
						} else {
							rollback(otsu);
							return null;
						}
						break;
						
					case "10+":
						if(coin10 > 0) {
							otsu.setCoin10(otsu.getCoin10()+1);
							otsuri -= 10;
							coin10 -= 1;
						} else {
							rollback(otsu);
							return null;
						}
						break;
					
					default:
						rollback(otsu);
						return null;
				}
			}
			
			//投入银币存入售卖机
			coin500 += customer.getCoin500();
			coin100 += customer.getCoin100();
			coin50 += customer.getCoin50();
			coin10 += customer.getCoin10();
			zantaka -= otsu.getOtsuri();
			
			
			return otsu;
			
		}
		
	}
	
	private static class Customer {
		
		private Integer konyu=0;
		
		private Integer tonyu=0;
		private Integer coin10=0;
		private Integer coin50=0;
		private Integer coin100=0;
		private Integer coin500=0;
		
		public Integer getKonyu() {
			return konyu;
		}

		public void setKonyu(Integer konyu) {
			this.konyu = konyu;
		}

		public Integer getTonyu() {
			return tonyu;
		}

		public void setTonyu(Integer tonyu) {
			this.tonyu = tonyu;
		}

		public Integer getCoin10() {
			return coin10;
		}

		public void setCoin10(Integer coin10) {
			this.coin10 = coin10;
		}

		public Integer getCoin50() {
			return coin50;
		}

		public void setCoin50(Integer coin50) {
			this.coin50 = coin50;
		}

		public Integer getCoin100() {
			return coin100;
		}

		public void setCoin100(Integer coin100) {
			this.coin100 = coin100;
		}

		public Integer getCoin500() {
			return coin500;
		}

		public void setCoin500(Integer coin500) {
			this.coin500 = coin500;
		}

		public Customer(Integer konyu, Integer coin500, Integer coin100,
				Integer coin50, Integer coin10) {
			super();
			this.konyu = konyu;
			this.coin10 = coin10;
			this.coin50 = coin50;
			this.coin100 = coin100;
			this.coin500 = coin500;
			
			this.tonyu = coin10*10 + coin50*50
        			+ coin100*100 + coin500*500;
		}
		
	}
	
	private static class Otsuri {
		
		private Integer flag;
		private Integer otsuri=0;
		private Integer coin10=0;
		private Integer coin50=0;
		private Integer coin100=0;
		private Integer coin500=0;
		
		public Integer getCoin10() {
			return coin10;
		}

		public void setCoin10(Integer coin10) {
			this.coin10 = coin10;
		}

		public Integer getCoin50() {
			return coin50;
		}

		public void setCoin50(Integer coin50) {
			this.coin50 = coin50;
		}

		public Integer getCoin100() {
			return coin100;
		}

		public void setCoin100(Integer coin100) {
			this.coin100 = coin100;
		}

		public Integer getCoin500() {
			return coin500;
		}

		public void setCoin500(Integer coin500) {
			this.coin500 = coin500;
		}

		public Integer getFlag() {
			return flag;
		}

		public void setFlag(Integer flag) {
			this.flag = flag;
		}

		public Integer getOtsuri() {
			return otsuri;
		}

		public void setOtsuri(Integer zantaka) {
			this.otsuri = zantaka;
		}

		public Otsuri(Integer coin10, Integer coin50, Integer coin100,
				Integer coin500) {
			super();
			this.coin10 = coin10;
			this.coin50 = coin50;
			this.coin100 = coin100;
			this.coin500 = coin500;
		}

		public Otsuri() {
			super();
		}
		
		
		
		
	}
}
