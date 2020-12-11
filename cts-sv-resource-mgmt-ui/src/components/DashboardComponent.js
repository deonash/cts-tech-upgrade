import React, { Component } from "react";
import SVClientDataService from "../services/svclient.data.service";

class DashboardComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "",
    };
    this.loadUsers = this.loadUsers.bind(this);
  }

  componentDidMount() {
    this.loadUsers();
  }

  loadUsers() {
    SVClientDataService.loadUsers()
      .then((response) => {
        this.setState({
          message: response.data,
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
export default DashboardComponent;
