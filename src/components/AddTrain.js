import React, { useState, useEffect } from "react";
import { useHistory, useParams } from "react-router-dom";
import SearchService from "../Services/SearchService.js";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

toast.configure();

const AddTrain = () => {
  /**To Show Add Train Toastify Text */
  const notify = () => {
    toast("Train Added Successfully", {
      position: "top-center",
      autoClose: 3000,
    });
  };
  const [trainNo, settrainNo] = useState("");
  const [trainName, settrainName] = useState("");
  const [sourceStation, setsourceStation] = useState("");
  const [destinationStation, setdestinationStation] = useState("");
  const [arrivalTime, setarrivalTime] = useState("");
  const [deptTime, setdeptTime] = useState("");
  const [duration, setduration] = useState("");
  const [noOfSeats, setnoOfSeats] = useState("");
  const [firstClassACFare, setfirstClassACFare] = useState("");
  const [twoTierAcFare, settwoTierAcFare] = useState("");
  const [threeTierAcFare, setthreeTierAcFare] = useState("");
  const [sleeperFare, setsleeperFare] = useState("");
  const history = useHistory();
  const { id } = useParams();

  const saveOrUpdateTrains = (e) => {
    e.preventDefault();
    const TrainDetails = {
      trainNo,
      trainName,
      sourceStation,
      destinationStation,
      arrivalTime,
      deptTime,
      duration,
      noOfSeats,
      firstClassACFare,
      twoTierAcFare,
      threeTierAcFare,
      sleeperFare,
    };
    if (id) {
      SearchService.updateTrain(id, TrainDetails)
        .then((response) => {
          alert("Your Train has been updated");
          history.push("/adminTrainList");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      SearchService.addTrain(TrainDetails)
        .then((response) => {
          alert("Your Train has been Added");
          history.push("/adminTrainList");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };
  useEffect(() => {
    SearchService.getTrainById(trainNo)
      .then((response) => {
        settrainNo(response.data.trainNo);
        settrainName(response.data.trainName);
        setsourceStation(response.data.sourceStation);
        setdestinationStation(response.data.destinationStation);
        setarrivalTime(response.data.arrivalTime);
        setdeptTime(response.data.deptTime);
        setduration(response.data.duration);
        setnoOfSeats(response.data.noOfSeats);
        setfirstClassACFare(response.data.firstClassACFare);
        settwoTierAcFare(response.data.twoTierAcFare);
        setthreeTierAcFare(response.data.threeTierAcFare);
        setsleeperFare(response.data.sleeperFare);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const title = () => {
    if (id) {
      return <h2 className="text-center">Update Train</h2>;
    } else {
      return <h2 className="text-center">Add Train</h2>;
    }
  };
  return (
    <div>
      <br></br>
      <br></br>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {title()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">TrainNo</label>

                  <input
                    type="text"
                    placeholder="Enter Train Number"
                    name="trainNo"
                    className="form-control"
                    value={trainNo}
                    onChange={(e) => settrainNo(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Train Name</label>

                  <input
                    type="text"
                    placeholder="Enter Train Name"
                    name="trainName"
                    className="form-control"
                    value={trainName}
                    onChange={(e) => settrainName(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Source Station</label>

                  <input
                    type="text"
                    placeholder="Enter start point"
                    name="sourceStation"
                    className="form-control"
                    value={sourceStation}
                    onChange={(e) => setsourceStation(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Destination Station</label>

                  <input
                    type="text"
                    placeholder="Enter end point"
                    name="destinationStation"
                    className="form-control"
                    value={destinationStation}
                    onChange={(e) => setdestinationStation(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">ArrivalTime</label>

                  <input
                    type="text"
                    placeholder="Enter Arrival Time"
                    name="arrivalTime"
                    className="form-control"
                    value={arrivalTime}
                    onChange={(e) => setarrivalTime(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">DeptTime</label>

                  <input
                    type="text"
                    placeholder="Enter Departure Time"
                    name="deptTime"
                    className="form-control"
                    value={deptTime}
                    onChange={(e) => setdeptTime(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Duration</label>

                  <input
                    type="text"
                    placeholder="Enter Duration"
                    name="duration"
                    className="form-control"
                    value={duration}
                    onChange={(e) => setduration(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">NoOfSeats</label>

                  <input
                    type="text"
                    placeholder="Enter Number of seats"
                    name="noOfSeats"
                    className="form-control"
                    value={noOfSeats}
                    onChange={(e) => setnoOfSeats(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">firstClassACFare</label>

                  <input
                    type="text"
                    placeholder="Enter FirstClass AC Fare"
                    name="firstClassACFare"
                    className="form-control"
                    value={firstClassACFare}
                    onChange={(e) => setfirstClassACFare(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">TwoTierAcFare</label>

                  <input
                    type="text"
                    placeholder="Enter TwoTier AC Fare"
                    name="twoTierAcFare"
                    className="form-control"
                    value={twoTierAcFare}
                    onChange={(e) => settwoTierAcFare(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">ThreeTierAcFare</label>

                  <input
                    type="text"
                    placeholder="Enter ThreeTier AC Fare"
                    name="threeTierAcFare"
                    className="form-control"
                    value={threeTierAcFare}
                    onChange={(e) => setthreeTierAcFare(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">sleeperFare</label>

                  <input
                    type="text"
                    placeholder="Enter SleeperFare"
                    name="sleeperFare"
                    className="form-control"
                    value={sleeperFare}
                    onChange={(e) => setsleeperFare(e.target.value)}
                  ></input>
                </div>
                <Link
                  onClick={(e) => {
                    saveOrUpdateTrains(e);
                  }}
                  to="/adminTrainList"
                  className="btn btn-success"
                >
                  {" "}
                  Submit{" "}
                </Link>
                <Link to="/adminTrainList" className="btn btn-danger">
                  {" "}
                  Cancel{" "}
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddTrain;
