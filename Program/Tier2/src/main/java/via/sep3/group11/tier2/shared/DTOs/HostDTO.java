package via.sep3.group11.tier2.shared.DTOs;

import via.sep3.group11.tier2.shared.domain.Host;

public class HostDTO {
    private Host host;
    private String errorMessage;

    public HostDTO(Host host, String errorMessage) {
        this.host = host;
        this.errorMessage = errorMessage;
    }

    public Host getHost() {
        return host;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
