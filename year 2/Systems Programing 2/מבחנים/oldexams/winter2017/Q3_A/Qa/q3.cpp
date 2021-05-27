#include "Tree.h"
#include "Plant.h"
#include "Flower.h"
#include "Bush.h"

int main() {

  Plant* PlantList[5];
  
  PlantList[0]= new Tree();
  PlantList[1]= new Flower();
  PlantList[2]= new Tree(2,1.5);
  PlantList[3]= new Bush();
  PlantList[4]= new Bush(1,1);

  for(int i=0 ; i<5 ; i++) {
    cout << *PlantList[i] << endl;
    (*PlantList[i])++;
    cout << *PlantList[i] << endl;
    delete PlantList[i];
  }
  
  return 0;
}
