import Post from "../PostContainer/Post";
import { useState } from "react";

function Dashboard() {
  const [inputValue, setInputValue] = useState("");

  const handleButtonClick = () => {
    console.log("The text is: ", inputValue);
  };

  // const handleInputChange = (e) => {
  //   setInputValue(e.target.value);
  // };

  // const [firstPostTitle, setFirstPostTitle] = useState("First Post Title");

  // const handleUpdateTitle = (e) => {
  //   setFirstPostTitle(e.target.value);
  // };

  // return (
  //   <div>
  //     <Post />
  //     <input
  //       type="text"
  //       onChange={handleUpdateTitle}
  //       value={firstPostTitle}
  //       placeholder="Type Something . . . "
  //     />
  //     <button>Button</button>
  //   </div>
  // );

  return (
    <div>
      <Post />
      <input
        type="text"
        // onChange={handleInputChange}
        value={inputValue}
        placeholder="Type Something . . . "
      ></input>
      <button onClick={handleButtonClick}>Button</button>
    </div>
  );
}

export default Dashboard;
