import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Header from "./components/Header";
import Showcase from "./components/Showcase";
import Footer from "./components/Footer";
import Login from "./components/Login.js";
import Destinations from "./components/Destinations";
import Error from "./components/Error";
import Search from "./components/Search";
import AddTrain from "./components/AddTrain";
import TrainList from "./TrainList";
import Booking from "./components/Booking";
import UserRegister from "./components/UserRegister";
import BookingList from "./components/BookingList";
import PaymentForm from "./components/PaymentForm";
import UserLogin from "./components/UserLogin";
import PaymentSuccess from "./components/PaymentSuccess";

function App() {
  return (
    <Router>
      <Header />

      <Switch>
        <Route exact path="/">
          <Showcase />
          <Destinations />
          <Footer/>
        </Route>

        <Route exact path="/login">
          <Login />
          <Footer/>
        </Route>

        <Route path="/userregistration">
          <UserRegister />
          <Footer/>
        </Route>

        <Route path="/userlogin">
          <UserLogin />
          <Footer/>
        </Route>

        <Route exact path="/adminTrainList">
           <TrainList/>
           <Footer/>
        </Route>

        <Route exact path="/trainList">
          <BookingList></BookingList>
          <Footer/>
        </Route>

        <Route exact path="/booking">
          <Booking></Booking>
          <Footer/>
        </Route>

       <Route exact path="/edit-train/:id">
          <AddTrain/>
          <Footer/>
        </Route>

        <Route exact path="/addTrain">
        <AddTrain/>
        <Footer/>
        </Route> 

        <Route exact path="/search">
          <Search />
          <Footer/>
        </Route>

        {/* <Route path="/checkin">
          <Booking />
          <Footer/>
        </Route> */}

        <Route exact path="/payment">
          <PaymentForm></PaymentForm>
          <Footer/>
        </Route>
        
        <Route exact path="/paymentSucessful">
          <PaymentSuccess></PaymentSuccess>
          <Footer/>
        </Route>
        
        <Route path="*">
          <Error />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
