
const mongoose = require("mongoose");

const reservationSchema = mongoose.Schema({
    name: {
        type: String,
        required: true,
        unique: true,
    },
    isAccepted: {
        type: Bool,
        required: 0,
    }

  
});

const reservations = mongoose.model("reservations", reservationsSchema);

module.exports = { reservations };
