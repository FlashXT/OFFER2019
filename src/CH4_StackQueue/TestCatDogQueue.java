package CH4_StackQueue;

/********************************************************************
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *********************************************************************/

 class Pet {
    private String type;
    public Pet(){}
    public Pet(String type){
        this.type = type;
    }
    public String gettype(){
        return this.type;
    }

}
class Cat extends Pet{
    public Cat(){
        super("Cat");
    }
}

class Dog extends Pet{
    public Dog(){
        super("Dog");
    }
}


public class TestCatDogQueue{
    class myPet{
        Pet pet;
        int index;
        public myPet(Pet pet,int index){
            this.pet = pet;
            this.index = index;
        }
    }
     private ArrayQueue<myPet> dogqueue = new ArrayQueue<>();
     private ArrayQueue<myPet> catqueue = new ArrayQueue<>();
     public void add(Pet pet,int index){
        String type = pet.gettype();
        if(type.equals("Dog")){
            myPet mp = new myPet(pet,index);
            dogqueue.enqueue(mp);
        }
        if(type.equals("Cat")){
            myPet mp = new myPet(pet,index);
            catqueue.enqueue(mp);
        }

    }
    public void pollAll(){
        myPet temp;
        while(!dogqueue.isEmpty()&&!catqueue.isEmpty()){

            if(dogqueue.peek().index > catqueue.peek().index)
                temp = catqueue.dequeue();
            else
                temp = dogqueue.dequeue();
            System.out.println(temp.pet.gettype()+","+temp.index);
        }
        while(!dogqueue.isEmpty()){
            temp = dogqueue.dequeue();
            System.out.println(temp.pet.gettype()+","+temp.index);
        }
        while(!catqueue.isEmpty()){
            temp = catqueue.dequeue();
            System.out.println(temp.pet.gettype()+","+temp.index);
        }

    }
    public void pollDog(){
        myPet temp;
        while(!dogqueue.isEmpty()){
            temp = dogqueue.dequeue();
            System.out.println(temp.pet.gettype()+","+temp.index);
        }

    }
    public void pollCat(){
         myPet temp;
        while(!catqueue.isEmpty()){
            temp = catqueue.dequeue();
            System.out.println(temp.pet.gettype()+","+temp.index);
        }
    }
    public boolean isEmpty(){
         return dogqueue.isEmpty()&&catqueue.isEmpty();
    }
    public boolean isDogEmpty(){
        return dogqueue.isEmpty();
    }
    public boolean isCatEmpty(){
        return catqueue.isEmpty();
    }
    public static void main(String [] args){
        TestCatDogQueue dcqueue = new TestCatDogQueue();
        Pet []pets = new Pet[7];
        pets[0] = new Dog();
        pets[1] = new Cat();
        pets[2] = new Dog();
        pets[3] = new Dog();
        pets[4] = new Cat();
        pets[5] = new Cat();
        pets[6] = new Cat();

        for(int i = 0; i< pets.length;i++){
            dcqueue.add(pets[i],i);
        }
        dcqueue.pollAll();
        dcqueue.pollDog();
        dcqueue.pollCat();

        System.out.println(dcqueue.isEmpty());
        System.out.println(dcqueue.isDogEmpty());
        System.out.println(dcqueue.isCatEmpty());

    }
}