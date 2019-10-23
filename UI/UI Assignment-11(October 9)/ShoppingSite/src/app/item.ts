export class Item {
    id : Number;
    title : String;
    price : Number;
    imageUrl : String;
    category : String;
    quantity : number = 0;

    public toString = () : string => {
        return `Item (${this.title})`;
    }
}
