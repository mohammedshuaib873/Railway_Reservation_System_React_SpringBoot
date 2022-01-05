import React, { useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import BookService from "../Services/BookService";
import { Button, Modal, Input } from "react-bootstrap";
import { Link } from "react-router-dom";
import "./Booking.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
toast.configure();

const Booking = () => {
  /**To Show Add Toastify Text */
  const notify = () => {
    toast.success({
      position: "top-center",
      autoClose: false,
    });
  };
  const [id, setid] = useState("");
  const [name, setname] = useState("");
  const [age, setage] = useState("");
  const [sex, setsex] = useState("");
  const [address, setaddress] = useState("");
  const [trainNo, settrainNo] = useState("");
  const [trainName, settrainName] = useState("");
  const [sourceStation, setsourceStation] = useState("");
  const [destinationStation, setdestinationStation] = useState("");
  const [classType, setclassType] = useState("");
  const [adults, setadults] = useState("");
  const [children, setchildren] = useState("");
  const [payment, setpayment] = useState("");
  const [pnrNo, setpnrNo] = useState("");
  const history = useHistory();

  const bookTrain = (e) => {
    e.preventDefault();
    const UserDetails = {
      id,
      name,
      age,
      sex,
      address,
      trainNo,
      trainName,
      sourceStation,
      destinationStation,
      classType,
      adults,
      children,
      pnrNo,
      payment,
    };

    BookService.bookTrain(UserDetails)
      .then((response) => {
        var e = JSON.stringify(response.data);
        alert(e);
        console.log(response);
        history.push("/booking");
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <form>
      <React.Fragment>
        <div className="booking-container">
          <h1 className="booking">BOOKING FORM</h1>
          <hr></hr>
          <p className="instruction">
            Please fill in this form to book a train ticket.
          </p>
          <div className="form-booking">
            <label>
              <b>Name</b>
            </label>
            <input
              type="text"
              name="name"
              id="name"
              placeholder="Enter Your Name"
              required
              value={name}
              onChange={(e) => setname(e.target.value)}
            ></input>

            <label>
              <b>Age</b>
            </label>
            <input
              type="text"
              name="Age"
              id="age"
              placeholder="Enter Your Age"
              required
              value={age}
              onChange={(e) => setage(e.target.value)}
            ></input>

            <label>
              <b>Gender</b>
            </label>
            <input
              type="text"
              name="sex"
              id="sex"
              placeholder="Enter Your Gender"
              required
              value={sex}
              onChange={(e) => setsex(e.target.value)}
            ></input>

            <label>
              <b>Address</b>
            </label>
            <input
              type="text"
              name="address"
              id="address"
              placeholder="Enter Your Address"
              required
              value={address}
              onChange={(e) => setaddress(e.target.value)}
            ></input>

            <label>
              <b>Train No</b>
            </label>
            <input
              type="text"
              name="trainNo"
              id="trainNo"
              placeholder="Enter Your TrainNo"
              required
              value={trainNo}
              onChange={(e) => settrainNo(e.target.value)}
            ></input>

            <label>
              <b>Train Name</b>
            </label>
            <input
              type="text"
              name="trainName"
              id="trainName"
              placeholder="Enter Your TrainName"
              required
              value={trainName}
              onChange={(e) => settrainName(e.target.value)}
            ></input>

            <label for="sourceStation">
              <b>Source Station</b>
            </label>
            <input
              type="text"
              name="sourceStation"
              id="sourceStation"
              placeholder="Enter Your SourceStation"
              required
              value={sourceStation}
              onChange={(e) => setsourceStation(e.target.value)}
            ></input>

            <label for="destinationStation">
              <b>Destination Station</b>
            </label>
            <input
              type="text"
              name="destinationStation"
              id="destinationStation"
              placeholder="Enter Your DestinationStation"
              required
              value={destinationStation}
              onChange={(e) => setdestinationStation(e.target.value)}
            ></input>

            <label for="classType">
              <b>ClassType</b>
            </label>
            <input
              type="text"
              name="classType"
              id="classType"
              placeholder="Enter Your ClassType"
              required
              value={classType}
              onChange={(e) => setclassType(e.target.value)}
            ></input>

            <label for="adults">
              <b>Adults</b>
            </label>
            <input
              type="text"
              name="adults"
              id="adults"
              placeholder="Enter Your Adults"
              required
              value={adults}
              onChange={(e) => setadults(e.target.value)}
            ></input>

            <label for="children">
              <b>Children</b>
            </label>
            <input
              type="text"
              name="children"
              id="children"
              placeholder="Enter Your Children"
              required
              value={children}
              onChange={(e) => setchildren(e.target.value)}
            ></input>

            <label for="payment">
              <b>Payment</b>
            </label>
            <input
              type="text"
              name="payment"
              id="payment"
              placeholder="Enter Your Payment"
              required
              value={payment}
              onChange={(e) => setpayment(e.target.value)}
            ></input>

            <hr></hr>
            <Link
              className="btn btn-success"
              onClick={(e) => {
                bookTrain(e);
              }}
            >
              BOOK{" "}
            </Link>
            <button type="submit" className="btn btn-danger">
              {" "}
              Cancel{" "}
            </button>
            <Link className="btn btn-info" to="/payment">
              {" "}
              Proceed To Payment{" "}
            </Link>
            <ToastContainer />
          </div>
        </div>
      </React.Fragment>
    </form>
  );
};

export default Booking;
