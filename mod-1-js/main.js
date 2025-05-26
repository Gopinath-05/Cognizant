// Task 1: Basic Setup
console.log("Welcome to the Community Portal");
$(window).on("load", () => alert("Page fully loaded!"));

// Task 4: Closure for Registration Tracking
const createRegistrationTracker = () => {
  let totalRegistrations = 0;
  return {
    register: () => {
      totalRegistrations++;
      return totalRegistrations;
    },
    getTotal: () => totalRegistrations
  };
};
const tracker = createRegistrationTracker();

// Task 5: Event Class with Prototype
class Event {
  constructor(name, date, seats, category) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
  }

  checkAvailability() {
    return this.seats > 0 ? `${this.name} has ${this.seats} seats available.` : `${this.name} is fully booked.`;
  }
}

// Task 2 & 6: Event Data and Array
const events = [
  { name: "Music Festival", date: "2025-06-01", seats: 100, category: "Music" },
  { name: "Tech Talk", date: "2025-07-15", seats: 50, category: "Tech" },
  { name: "Art Workshop", date: "2025-05-20", seats: 0, category: "Art" }
];

// Task 4: Functions for Event Operations
const addEvent = (events, { name, date, seats = 50, category = "General" }) => {
  events.push(new Event(name, date, seats, category));
};

const registerUser = (event) => {
  if (event.seats > 0) {
    event.seats--;
    console.log(`Registered for ${event.name}. Total registrations: ${tracker.register()}`);
    renderEvents(); // Task 7: Update UI
  } else {
    $("#events").append("<div class='error'>No seats available!</div>").fadeIn();
  }
};

const filterEventsByCategory = (events, category, callback) => {
  return events.filter(event => callback(event, category));
};

// Task 3: Conditionals and Loops
const displayValidEvents = (events) => {
  const today = new Date("2025-05-24");
  const validEvents = [];
  events.forEach(event => {
    try {
      if (new Date(event.date) < today) throw new Error(`${event.name} is in the past.`);
      if (event.seats === 0) throw new Error(`${event.name} is fully booked.`);
      validEvents.push(event);
    } catch (error) {
      console.error(error.message);
    }
  });
  return validEvents;
};

// Task 7 & 14: DOM Manipulation with jQuery
const renderEvents = (filteredEvents = displayValidEvents(events)) => {
  $("#events").empty();
  filteredEvents.forEach((event, index) => {
    const card = $(`
      <div class="event-card">
        ${event.name} - ${event.seats} seats (${event.category})
        <button class="registerBtn" data-index="${index}">Register</button>
      </div>
    `).hide();
    $("#events").append(card);
    card.fadeIn(); // Task 14: jQuery Animation
  });

  // Task 8: Event Handling for Register Buttons
  $(".registerBtn").click(function() {
    const index = $(this).data("index");
    registerUser(events[index]);
  });
};

// Task 8: Category Filter and Search
$("#categoryFilter").on("change", () => {
  const category = $("#categoryFilter").val();
  const callback = (event, cat) => cat === "All" ? true : event.category === cat;
  const filtered = filterEventsByCategory(events, category, callback);
  renderEvents(filtered);
});

$("#search").on("keydown", (e) => {
  if (e.key === "Enter") {
    const query = e.target.value.toLowerCase();
    const filtered = events.filter(event => event.name.toLowerCase().includes(query));
    renderEvents(filtered);
  }
});

// Task 9 & 12: Async Fetch and POST
const fetchEvents = async () => {
  try {
    $("#loading").show();
    // Mock API: Replace with real endpoint like JSONPlaceholder
    const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await response.json();
    // Simulate event data
    const mockEvents = data.slice(0, 2).map((item, i) => ({
      name: `Event ${i + 1}`,
      date: `2025-06-0${i + 1}`,
      seats: 100 - i * 10,
      category: i % 2 ? "Music" : "Tech"
    }));
    events.push(...mockEvents); // Task 6: Add to array
    $("#loading").hide();
    renderEvents();
  } catch (error) {
    console.error("Fetch error:", error);
    $("#loading").hide();
  }
};

const submitRegistration = async (name, email, eventName) => {
  try {
    const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email, eventName })
    });
    setTimeout(() => {
      if (response.ok) {
        alert("Registration successful!");
      } else {
        alert("Registration failed.");
      }
    }, 1000); // Task 12: Simulate delay
  } catch (error) {
    console.error("Submission error:", error);
    alert("Error submitting registration.");
  }
};

// Task 11: Form Handling
$("#registerForm").on("submit", (event) => {
  event.preventDefault();
  const { name, email, event: eventName } = event.target.elements;

  // Task 11: Validation
  if (!name.value || !email.value.includes("@")) {
    $("#error").text("Please enter a valid name and email.");
    return;
  }

  $("#error").text(`Registered ${name.value} for ${eventName.value}!`);
  submitRegistration(name.value, email.value, eventName.value); // Task 12: POST to API
  event.target.reset();
});

// Task 10: Modern JS Features
const cloneAndFilter = () => {
  const clonedEvents = [...events]; // Spread operator
  const { name, seats } = clonedEvents[0] || {}; // Destructuring
  console.log(`First event: ${name || "None"} with ${seats || 0} seats`);
  return clonedEvents.filter(event => event.category === "Music"); // Task 6: Filter
};

// Task 5: Object Entries
const logEventDetails = () => {
  const event = events[0] || {};
  console.log("Event details:", Object.entries(event));
};

// Task 13: Debugging Setup
const debugFormSubmission = () => {
  $("#registerForm").on("submit", (event) => {
    const { name, email, event: eventName } = event.target.elements;
    console.log("Submitting:", { name: name.value, email: email.value, event: eventName.value });
    // Use Chrome DevTools to inspect payload and set breakpoints
  });
};

// Initialize
fetchEvents();
cloneAndFilter();
logEventDetails();
renderEvents();

// Task 14: Benefit of Frameworks
console.log("React/Vue benefit: Component-based architecture simplifies state management and UI updates.");