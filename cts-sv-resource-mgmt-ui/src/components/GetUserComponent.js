import React, { Component } from "react";
import SVClientDataService from "../services/svclient.data.service";

class GetUserComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "",
    };
    this.getUsers = this.getUsers.bind(this);
  }

  componentDidMount() {
    this.getUsers();
  }

  getUsers() {
    SVClientDataService.getUsers()
      .then((response) => {
        this.setState({
          message: JSON.stringify(response.data),
        });
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  render() {
    return <h3>{this.state.message}</h3>;
  }
}

export default GetUserComponent;
