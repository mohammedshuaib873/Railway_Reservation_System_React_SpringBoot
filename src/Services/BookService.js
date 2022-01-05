import axios from'axios'
const BOOK_TRAIN_TICKET ='http://localhost:8084/user/book';

class BookService{
    bookTrain(UserDetails){
        return axios.post(BOOK_TRAIN_TICKET ,UserDetails)
    }

}
export default new BookService();