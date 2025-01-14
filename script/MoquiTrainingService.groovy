import org.moqui.context.ExecutionContext
import org.moqui.entity.EntityValue

ExecutionContext ec = context.ec

//def trainingId = context.trainingId
def trainingName = context.trainingName
def trainingDate = context.trainingDate
def trainingPrice = context.trainingPrice
def trainingDuration = context.trainingDuration

if (!trainingName) {
    ec.message.addError("Training name is required.")
    return
}
if (!trainingDate) {
    ec.message.addError("Training date is required.")
    return
}
def trainingId = ec.entity.sequencedIdPrimary("MoquiTraining", null, null)

EntityValue trainingRecord = ec.entity.makeValue("MoquiTraining")

trainingRecord.set("trainingId", trainingId) //it is  Explicitly setting trainingId
trainingRecord.set("trainingName", trainingName)
trainingRecord.set("trainingDate", trainingDate)
//trainingRecord.set("trainingPrice", trainingPrice)
//trainingRecord.set("trainingDuration", trainingDuration)

trainingRecord.set("trainingPrice", trainingPrice != null ? trainingPrice : 0)
trainingRecord.set("trainingDuration", trainingDuration != null ? trainingDuration: 0)

trainingRecord = trainingRecord.create()

context.trainingId = trainingRecord.get("trainingId")


